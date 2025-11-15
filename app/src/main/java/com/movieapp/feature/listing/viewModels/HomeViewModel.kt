package com.movieapp.feature.listing.viewModels

import androidx.lifecycle.ViewModel
import com.movieapp.feature.listing.repository.HomeRepository
import jakarta.inject.Inject

class HomeViewModel @Inject constructor(private val repository: HomeRepository) : ViewModel() {
    fun getTrendingMovies() = repository.getTrendingMovies()
    fun observeTrendingMovies() = repository.observeTrendingMovies()
}