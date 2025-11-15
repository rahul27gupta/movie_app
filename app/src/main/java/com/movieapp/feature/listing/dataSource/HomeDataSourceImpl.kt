package com.movieapp.feature.listing.dataSource

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.movieapp.feature.listing.models.MoviesResponse
import com.movieapp.network.ApiServices
import com.movieapp.network.Resource
import jakarta.inject.Inject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeDataSourceImpl @Inject constructor(
    private val apiService: ApiServices
) : HomeDataSource {

    private val _trendingMovies = MutableLiveData<Resource<MoviesResponse?>>()
    override fun observeTrendingMovies(): LiveData<Resource<MoviesResponse?>> = _trendingMovies
    override fun getTrendingMovies() {
        CoroutineScope(Dispatchers.IO).launch {
            _trendingMovies.postValue(Resource.Loading())
            try {
                val response = apiService.getTrendingMovies(
                    language = "en-US",
                    apikey = "9c7b36bb28441a6137e459522f563db5"
                )
                if (response.isSuccessful) {
                    _trendingMovies.postValue(Resource.Success(data = response.body()))
                } else {
                    _trendingMovies.postValue(Resource.Error(response.message()))
                }

            } catch (e: Exception) {
                _trendingMovies.postValue(Resource.Error(e.message))
            }
        }
    }
}