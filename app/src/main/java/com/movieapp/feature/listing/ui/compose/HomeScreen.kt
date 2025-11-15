package com.movieapp.feature.listing.ui.compose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.movieapp.base.component.AppBar
import com.movieapp.base.theme.MoviesAppTheme
import com.movieapp.feature.listing.models.Movie
import com.movieapp.feature.listing.models.MoviesResponse
import com.movieapp.network.Resource

@Composable
fun HomeScreen(
    movies: MoviesResponse?
) {
    Scaffold(
        topBar = { AppBar(title = "Movies") },
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentAlignment = Alignment.Center
        ) {
            val movies = movies?.listOfMovies
            if (movies.isNullOrEmpty()) {
                Text("No movies available")
            } else {
                MoviesGrid(
                    movies = movies,
                    onMovieClick = {}
                )
            }
        }
    }
}