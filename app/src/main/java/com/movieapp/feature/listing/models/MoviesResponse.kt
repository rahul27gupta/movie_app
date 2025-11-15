package com.movieapp.feature.listing.models

import com.google.gson.annotations.SerializedName

data class MoviesResponse(

    @SerializedName("Search")
    val listOfMovies: ArrayList<Movie>? = null

)

data class Movie(
    @SerializedName("Title")
    val title: String? = null,
    @SerializedName("Year")
    val year: String? = null,
    @SerializedName("imdID")
    val imdID: String? = null,
    @SerializedName("Type")
    val type: String? = null,
    @SerializedName("Poster")
    val poster: String? = null
)