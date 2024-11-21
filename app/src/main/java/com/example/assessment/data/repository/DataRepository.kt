package com.example.assessment.data.repository

import com.example.assessment.data.models.FlickerResponse
import retrofit2.Response

interface DataRepository {
    suspend fun getImages(tags: String) : Response<FlickerResponse>
}