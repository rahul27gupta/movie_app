package com.movieapp.feature.listing.dataSource

import androidx.lifecycle.LiveData
import com.movieapp.feature.listing.models.MoviesResponse
import com.movieapp.network.Resource

interface HomeDataSource {
    fun getTrendingMovies()
    fun observeTrendingMovies(): LiveData<Resource<MoviesResponse?>>
}