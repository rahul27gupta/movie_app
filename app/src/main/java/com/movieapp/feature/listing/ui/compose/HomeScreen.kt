package com.movieapp.feature.listing.ui.compose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import com.movieapp.base.component.SearchBar
import com.movieapp.base.theme.MoviesAppTheme
import com.movieapp.feature.listing.models.Movie

@Composable
@Preview
fun HomePreview() {
    MoviesAppTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            HomeScreen(
                searchQuery = "",
                filteredMovies = arrayListOf(
                    Movie(id = "1", title = "Test Movie 1", poster = ""),
                    Movie(id = "2", title = "Test Movie 2", poster = "")
                ),
                onSearchQueryChange = {},
                onMovieClick = {}
            )
        }
    }
}

@Composable
fun HomeScreen(
    searchQuery: String,
    filteredMovies: ArrayList<Movie>?,
    onSearchQueryChange: (String) -> Unit,
    onMovieClick: (Movie) -> Unit
) {
    Scaffold(
        topBar = { AppBar(title = stringResource(R.string.title_movies)) },
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            SearchBar(
                query = searchQuery,
                onQueryChange = onSearchQueryChange
            )
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                if (filteredMovies.isNullOrEmpty()) {
                    Text(
                        text = if (searchQuery.length >= 3) {
                            stringResource(R.string.no_movies_found, searchQuery)
                        } else {
                            stringResource(R.string.no_movies_available)
                        },
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.headlineLarge,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp, horizontal = 16.dp)
                    )
                } else {
                    MoviesGrid(
                        movies = filteredMovies,
                        onMovieClick = onMovieClick
                    )
                }
            }
        }
    }
}