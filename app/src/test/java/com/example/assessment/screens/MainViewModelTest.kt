package com.example.assessment.screens

import com.example.assessment.MainViewModel
import com.example.assessment.data.models.Image
import com.example.assessment.data.repository.DataRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.setMain
import org.junit.Assert.*

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MainViewModelTest {

    private lateinit var viewModel: MainViewModel
    @Mock
    private lateinit var dataRepository: DataRepository


    private val testDispatcher = StandardTestDispatcher()

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
        viewModel = MainViewModel(
            dataRepository
        )
    }


    @Test
    fun `verify the ImageDetailsObject returns the SearchResultImageData item`() {
        val searchItem = viewModel.getTheImageDetailsObject(
            Image(
                title = "Test Title",
                link = "Test Link",
                media = com.example.assessment.data.models.Media(
                    m = "Test Media"
                ),
                date_taken = "2023-06-07T15:37:45-08:00",
                description = "Test Description",
                published = null,
                author = "Test Author",
                author_id = "Test Author ID",
                tags = "Test Tags"
            )
        )

        assertEquals(searchItem.title, "Test Title")
    }

}