package com.example.assessment.di

import com.example.assessment.data.repository.DataRepository
import com.example.assessment.data.repository.DataRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun provideDataRepository(
        DataRepositoryImpl: DataRepositoryImpl
    ): DataRepository
}