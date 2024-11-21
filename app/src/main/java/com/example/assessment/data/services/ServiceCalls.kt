package com.example.assessment.data.services

import com.example.assessment.data.models.FlickerResponse
import retrofit2.Response

import retrofit2.http.GET
import retrofit2.http.Query



interface ServiceCalls {

   @GET("services/feeds/photos_public.gne")
    suspend fun getImagesWithTags(@Query("format") format: String = "json",
                                  @Query("nojsoncallback") noJsonCallBack: Int = 1,
                                  @Query("tags") tags: String) : Response<FlickerResponse>
}