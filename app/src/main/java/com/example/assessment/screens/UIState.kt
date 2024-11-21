package com.example.assessment.screens

import com.example.assessment.data.models.FlickerResponse

sealed class UIState {
    object Loading: UIState()
    data class Success(val response: FlickerResponse) : UIState()
    data class Error(val errorMessage: String): UIState()
    data class OnLaunch(val displayMessage: String): UIState()
}