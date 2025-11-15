package com.movieapp.feature.listing.ui.compose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.movieapp.base.theme.MoviesAppTheme
import com.movieapp.base.component.AppBar

@Composable
@Preview
fun HomePreview() {
    MoviesAppTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            HomeScreen()
        }
    }
}


@Composable
fun HomeScreen() {
    Scaffold(
        topBar = { AppBar(title = "Movies") },
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            MoviesGrid(
                movies = arrayListOf(),
                onMovieClick = {}
            )
        }

    }

}