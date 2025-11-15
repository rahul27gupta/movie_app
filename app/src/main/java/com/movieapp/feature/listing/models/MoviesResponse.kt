package com.movieapp.feature.listing.models

import com.google.gson.annotations.SerializedName

data class MoviesResponse(

    @SerializedName("results")
    val listOfMovies: ArrayList<Movie>? = null

)

data class Movie(
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("poster_path")
    val poster: String? = null,
    @SerializedName("title")
    val title: String? = null,
)