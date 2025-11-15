package com.movieapp.feature.listing.repository

import com.movieapp.feature.listing.models.MoviesResponse
import com.movieapp.network.Resource
import kotlinx.coroutines.flow.StateFlow

interface HomeRepository {
    val trendingMovies: StateFlow<Resource<MoviesResponse?>>
    suspend fun getTrendingMovies()
}