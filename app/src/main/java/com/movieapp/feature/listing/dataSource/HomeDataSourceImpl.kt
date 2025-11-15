package com.movieapp.feature.listing.dataSource

import com.movieapp.BuildConfig
import com.movieapp.feature.listing.models.MoviesResponse
import com.movieapp.network.ApiServices
import com.movieapp.network.Resource
import jakarta.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class HomeDataSourceImpl @Inject constructor(
    private val apiService: ApiServices
) : HomeDataSource {

    override suspend fun getTrendingMovies(): Resource<MoviesResponse?> {
        return withContext(Dispatchers.IO) {
            try {
                val response = apiService.getTrendingMovies(
                    language = "en-US",
                    apikey = BuildConfig.TMDB_API_KEY
                )
                if (response.isSuccessful) {
                    Resource.Success(data = response.body())
                } else {
                    Resource.Error(response.message())
                }
            } catch (e: Exception) {
                Resource.Error(e.message)
            }
        }
    }
}