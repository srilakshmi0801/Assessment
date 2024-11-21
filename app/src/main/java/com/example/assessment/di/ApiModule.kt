package com.example.assessment.di

import com.example.assessment.BASE_URL
import com.example.assessment.data.services.ServiceCalls
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object ApiModule{

    @Provides
    @Singleton
    fun provideMyApiCallsRetrofitBuilder() : ServiceCalls {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ServiceCalls::class.java)
    }
}