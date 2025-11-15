package com.movieapp.feature.listing.ui.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import com.movieapp.R
import com.movieapp.base.theme.MoviesAppTheme
import com.movieapp.base.utils.getParcelableCompat
import com.movieapp.feature.listing.models.Movie
import com.movieapp.feature.listing.ui.compose.MovieDetailScreen

class MovieDetailActivity : ComponentActivity() {

    private val movie: Movie? by lazy {
        intent.getParcelableCompat(getString(R.string.key_movie))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, true)
        setContent {
            MoviesAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    movie?.let {
                        MovieDetailScreen(
                            movie = it,
                            onBackClick = { finish() }
                        )
                    }
                }
            }
        }
    }

    companion object {
        fun newInstance(context: Context, movie: Movie): Intent {
            return Intent(context, MovieDetailActivity::class.java).apply {
                putExtra(context.getString(R.string.key_movie), movie)
            }
        }
    }
}