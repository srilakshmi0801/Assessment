package com.example.assessment.screens.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.assessment.data.models.Image
import com.example.assessment.MainViewModel
import com.example.assessment.R
import com.example.assessment.SEARCH_BAR_TEXT
import com.example.assessment.screens.UIState

@Composable
fun SearchComposable(
    mainViewModel: MainViewModel,
    modifier: Modifier,
    navigateToDetails: (Image) -> Unit
) {
    val state by mainViewModel.uiState.collectAsState()

    var value by rememberSaveable { mutableStateOf(SEARCH_BAR_TEXT) }

    Column {
        TextField(
            value = value,
            onValueChange = { tags ->
                value = tags
                mainViewModel.getTheImagesFromTheTag(tags)},
            placeholder = {
                Text(text = "Type Here")
            },
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp),
            singleLine = true,
            leadingIcon = {
                Icon(Icons.Default.Search, contentDescription = stringResource(R.string.search_icon))
            }
        )
        when (state) {
            is UIState.Error ->
                Column(
                    modifier = Modifier.fillMaxSize()
                ) {
                    Text((state as UIState.Error).errorMessage)
                }
            is UIState.OnLaunch ->
                Column(
                    modifier = Modifier.fillMaxSize()
                ) {
                    Text((state as UIState.OnLaunch).displayMessage)
                }
            UIState.Loading ->
                Column( modifier = Modifier.fillMaxSize()) {
                    CircularProgressIndicator(
                        modifier = Modifier.width(64.dp),
                        color = MaterialTheme.colorScheme.primary,
                        trackColor = MaterialTheme.colorScheme.primaryContainer
                    )
                }

            is UIState.Success ->
                SuccessComposable(state as UIState.Success, navigateToDetails)
        }
    }
}