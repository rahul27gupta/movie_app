package com.movieapp.di.module

import com.movieapp.feature.listing.repository.HomeRepository
import com.movieapp.feature.listing.viewModels.HomeViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ViewModelModule {

    @Provides
    @Singleton
    fun provideHomeViewModel(homeRepository: HomeRepository): HomeViewModelFactory {
        return HomeViewModelFactory(homeRepository)
    }
}