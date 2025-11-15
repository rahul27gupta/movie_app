package com.movieapp.feature.listing.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.core.view.WindowCompat
import com.movieapp.MovieApp
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
        setupView()
        setupObserver()
        /*setContent {
            NotesAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                }
            }
        }*/
    }


    private fun injectDependencies() {
        val appComponent = (application as MovieApp).appComponent
        appComponent.inject(this)
    }

    private fun setupObserver() {
        viewModel.observeTrendingMovies().observe(this) {
            when (it) {
                is Resource.Loading -> {
                    // TODO Loading Work
                }

                is Resource.Success -> {
                    // TODO Success Work
                }

                is Resource.Error -> {
                    // TODO Error Work
                }
            }
        }
    }


    private fun setupView() {
        viewModel.getTrendingMovies()
    }

}