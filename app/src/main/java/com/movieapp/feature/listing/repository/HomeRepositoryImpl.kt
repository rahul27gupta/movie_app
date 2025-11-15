package com.movieapp.feature.listing.repository

import com.movieapp.feature.listing.dataSource.HomeDataSource
import com.movieapp.feature.listing.models.MoviesResponse
import com.movieapp.network.Resource
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class HomeRepositoryImpl @Inject constructor(
    private val dataSource: HomeDataSource
) : HomeRepository {

    private val _trendingMovies = MutableStateFlow<Resource<MoviesResponse?>>(Resource.Loading())
    override val trendingMovies: StateFlow<Resource<MoviesResponse?>> =
        _trendingMovies.asStateFlow()

    override suspend fun getTrendingMovies() {
        val result = dataSource.getTrendingMovies()
        _trendingMovies.value = result
    }
}