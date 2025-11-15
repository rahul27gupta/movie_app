package com.movieapp.network

import com.movieapp.feature.listing.models.MoviesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServices {
    @GET("trending/movie/week")
    suspend fun getTrendingMovies(
        @Query("language") language: String,
        @Query("api_key") apikey: String,
    ): Response<MoviesResponse>
}