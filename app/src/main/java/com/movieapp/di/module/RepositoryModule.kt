package com.movieapp.di.module

import com.movieapp.feature.listing.repository.HomeRepository
import com.movieapp.feature.listing.repository.HomeRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun provideHomeRepository(homeRepository: HomeRepositoryImpl): HomeRepository

}