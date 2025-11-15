package com.movieapp.feature.listing.repository

import androidx.lifecycle.LiveData
import com.movieapp.feature.listing.models.MoviesResponse
import com.movieapp.network.Resource

interface HomeRepository {
    fun getTrendingMovies()
    fun observeTrendingMovies(): LiveData<Resource<MoviesResponse?>>
}