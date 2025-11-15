package com.movieapp.feature.listing.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.movieapp.feature.listing.models.MoviesResponse
import com.movieapp.feature.listing.repository.HomeRepository
import com.movieapp.network.Resource
import jakarta.inject.Inject
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel @Inject constructor(
    private val repository: HomeRepository
) : ViewModel() {

    val trendingMovies: StateFlow<Resource<MoviesResponse?>> = repository.trendingMovies
    fun getTrendingMovies() {
        viewModelScope.launch { repository.getTrendingMovies() }
    }

}