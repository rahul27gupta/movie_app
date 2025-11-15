package com.movieapp.feature.listing.ui.compose

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.movieapp.base.constans.Constants.IMAGE_BASE_URL
import com.movieapp.feature.listing.models.Movie

@Composable
fun MoviesGrid(movies: ArrayList<Movie>, onMovieClick: ((Movie) -> Unit)) {
    LazyVerticalGrid(
        modifier = Modifier.fillMaxSize(),
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(18.dp),
        verticalArrangement = Arrangement.spacedBy(18.dp)
    ) {
        items(movies) { movie ->
            MovieCard(
                movie = movie,
                onMovieClick = { onMovieClick(movie) }
            )
        }
    }

}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun MovieCard(
    movie: Movie,
    onMovieClick: (() -> Unit)
) {
    Column(
        modifier = Modifier.clickable { onMovieClick.invoke() }
    ) {
        GlideImage(
            model = IMAGE_BASE_URL.plus(movie.poster),
            contentDescription = "movie-image",
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(8.dp)),
            contentScale = ContentScale.Crop
        )
        Text(
            text = movie.title ?: "",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.labelLarge,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp, horizontal = 4.dp)
        )
    }
}