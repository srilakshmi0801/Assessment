package com.example.assessment.data.repository

import com.example.assessment.data.models.FlickerResponse
import com.example.assessment.data.services.ServiceCalls
import retrofit2.Response
import javax.inject.Inject

class DataRepositoryImpl @Inject constructor(
    private val serviceCalls: ServiceCalls
) : DataRepository {

    override suspend fun getImages(tags: String): Response<FlickerResponse> {
       return serviceCalls.getImagesWithTags(tags = tags)
    }


}