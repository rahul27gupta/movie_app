package com.movieapp.feature.listing.repository

import androidx.lifecycle.LiveData
import com.movieapp.feature.listing.dataSource.HomeDataSource
import com.movieapp.feature.listing.models.MoviesResponse
import com.movieapp.network.Resource
import jakarta.inject.Inject

class HomeRepositoryImpl @Inject constructor(private val dataSource: HomeDataSource) :
    HomeRepository {

    override fun getTrendingMovies() = dataSource.getTrendingMovies()
    override fun observeTrendingMovies(): LiveData<Resource<MoviesResponse?>> =
        dataSource.observeTrendingMovies()
}