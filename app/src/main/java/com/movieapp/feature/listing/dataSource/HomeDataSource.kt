package com.movieapp.feature.listing.dataSource

import com.movieapp.feature.listing.models.MoviesResponse
import com.movieapp.network.Resource

interface HomeDataSource {
    suspend fun getTrendingMovies(): Resource<MoviesResponse?>
}