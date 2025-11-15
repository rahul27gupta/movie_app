package com.movieapp.feature.listing.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.movieapp.feature.listing.repository.HomeRepository
import jakarta.inject.Inject

class HomeViewModelFactory @Inject constructor(private val homeRepository: HomeRepository) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(homeRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
