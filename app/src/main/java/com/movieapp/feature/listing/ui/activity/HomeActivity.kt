package com.movieapp.feature.listing.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import com.movieapp.MovieApp
import com.movieapp.base.theme.MoviesAppTheme
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
                    val searchQuery by viewModel.searchQuery.collectAsState()
                    val filteredMovies by viewModel.filteredMovies.collectAsState()

                    when (moviesState) {
                        is Resource.Loading -> {
                            Box(
                                modifier = Modifier.fillMaxSize(),
                                contentAlignment = Alignment.Center
                            ) {
                                CircularProgressIndicator()
                            }
                        }

                        is Resource.Success -> {
                            HomeScreen(
                                searchQuery = searchQuery,
                                filteredMovies = filteredMovies,
                                onSearchQueryChange = viewModel::updateSearchQuery,
                                onMovieClick = { movie ->
                                    startActivity(MovieDetailActivity.newInstance(this, movie))
                                }
                            )
                        }

                        is Resource.Error -> {
                            Box(
                                modifier = Modifier.fillMaxSize(),
                                contentAlignment = Alignment.Center
                            ) {
                                Text("Error: ${(moviesState as Resource.Error).message}")
                            }
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