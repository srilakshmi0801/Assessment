package com.example.assessment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.assessment.data.models.FlickerResponse
import com.example.assessment.data.models.Image
import com.example.assessment.data.repository.DataRepository
import com.example.assessment.screens.UIState
import com.example.assessment.screens.SearchResultImageData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Locale
import java.util.TimeZone
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val dataRepository: DataRepository
): ViewModel() {
    private val _uiState= MutableStateFlow<UIState>(
        UIState.OnLaunch(
            INITIAL_MESSAGE
        )
    )

    val uiState
        get() = _uiState

    fun getTheImagesFromTheTag(tags: String){
        _uiState.value = UIState.Loading
        viewModelScope.launch {
            val response = dataRepository.getImages(tags = tags)
            if(response.isSuccessful) {
                _uiState.value = UIState.Success(
                    response = response.body() as FlickerResponse
                )
            } else {
                _uiState.value = UIState.Error(
                    ERROR_MESSAGE
                )
            }

        }
    }

    fun getTheImageDetailsObject(item: Image): SearchResultImageData {
        return SearchResultImageData(
            media = item.media,
            title = item.title,
            description = item.description,
            author = item.author,
            publishedDate = formatDate(item.published)
        )

    }


    fun formatDate(date: String?): String {
        date?.let {
            val inputFormat = SimpleDateFormat(RESPONSE_DATE_FORMAT, Locale.getDefault())
            inputFormat.timeZone = TimeZone.getTimeZone(UTC)
            val outputFormat = SimpleDateFormat(DISPLAY_DATE_FORMAT, Locale.getDefault())
            val inputDate = inputFormat.parse(date)
            return inputDate?.let {
                outputFormat.format(it)
            } ?: ""
        }?: return ""
    }

}