package com.movieapp.feature.listing.ui.compose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.movieapp.R
import com.movieapp.base.component.AppBar
import com.movieapp.base.theme.MoviesAppTheme
import com.movieapp.feature.listing.models.Movie
import com.movieapp.feature.listing.models.MoviesResponse
import com.movieapp.network.Resource

@Composable
@Preview
fun HomePreview() {
    MoviesAppTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            HomeScreen(
                movies = MoviesResponse(
                    listOfMovies = arrayListOf(
                        Movie(id = "1", title = "Test Movie 1", poster = ""),
                        Movie(id = "2", title = "Test Movie 2", poster = "")
                    )
                ),
                onMovieClick = {}
            )
        }
    }
}

@Composable
fun HomeScreen(
    movies: MoviesResponse?,
    onMovieClick: ((Movie) -> Unit)
) {
    Scaffold(
        topBar = { AppBar(title = stringResource(R.string.title_movies)) },
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentAlignment = Alignment.Center
        ) {
            val moviesList = movies?.listOfMovies
            if (moviesList.isNullOrEmpty()) {
                Text(
                    text = stringResource(R.string.no_movies_available),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.headlineLarge,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp, horizontal = 4.dp)
                )
            } else {
                MoviesGrid(
                    movies = moviesList,
                    onMovieClick = onMovieClick
                )
            }
        }
    }
}