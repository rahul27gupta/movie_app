package com.movieapp.feature.listing.ui.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.movieapp.R
import com.movieapp.base.component.AppBar
import com.movieapp.base.constans.Constants.IMAGE_BASE_URL
import com.movieapp.feature.listing.models.Movie

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun MovieDetailScreen(
    movie: Movie,
    onBackClick: () -> Unit
) {
    Scaffold(
        topBar = {
            AppBar(
                title = stringResource(R.string.title_movie_detail),
                showBackButton = true,
                onBackClick = onBackClick
            )
        }
    ) { paddingValues ->
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            GlideImage(
                model = IMAGE_BASE_URL.plus(movie.poster),
                contentDescription = stringResource(R.string.movie_image),
                modifier = Modifier
                    .size(width = 260.dp, height = 300.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .padding(16.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = movie.title ?: stringResource(R.string.unknown_title),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp, horizontal = 16.dp)
            )
            Text(
                text = movie.overview ?: stringResource(R.string.unknown_overview),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp, horizontal = 16.dp)
            )
        }
    }
}