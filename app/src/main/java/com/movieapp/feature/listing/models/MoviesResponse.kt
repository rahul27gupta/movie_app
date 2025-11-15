package com.movieapp.feature.listing.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

data class MoviesResponse(

    @SerializedName("results")
    val listOfMovies: ArrayList<Movie>? = null

)

@Parcelize
data class Movie(
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("poster_path")
    val poster: String? = null,
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("overview")
    val overview: String? = null,
) : Parcelable