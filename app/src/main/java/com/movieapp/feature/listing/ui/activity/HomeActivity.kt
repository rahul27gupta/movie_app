package com.movieapp.feature.listing.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import com.movieapp.MovieApp
import com.movieapp.base.theme.MoviesAppTheme
import com.movieapp.feature.listing.models.MoviesResponse
import com.movieapp.feature.listing.ui.compose.HomeScreen
import com.movieapp.feature.listing.viewModels.HomeViewModel
import com.movieapp.feature.listing.viewModels.HomeViewModelFactory
import com.movieapp.network.Resource
import javax.inject.Inject

class HomeActivity : ComponentActivity() {
    @Inject
    lateinit var viewModelFactory: HomeViewModelFactory
    private val viewModel: HomeViewModel by viewModels { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, true)
        injectDependencies()
        viewModel.getTrendingMovies()
        setContent {
            MoviesAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val moviesState by viewModel.trendingMovies.collectAsState()
                    when (moviesState) {
                        is Resource.Loading -> {
                            // TODO Loading Screen
                        }

                        is Resource.Success -> {
                            HomeScreen(
                                movies = (moviesState as Resource.Success<MoviesResponse?>).data,
                                onMovieClick = { movie ->
                                    startActivity(MovieDetailActivity.newInstance(this, movie))
                                }
                            )
                        }

                        is Resource.Error -> {
                            // TODO Error Screen
                        }
                    }
                }
            }
        }
    }

    private fun injectDependencies() {
        val appComponent = (application as MovieApp).appComponent
        appComponent.inject(this)
    }
}