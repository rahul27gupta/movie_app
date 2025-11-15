package com.movieapp.feature.listing.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.movieapp.feature.listing.models.Movie
import com.movieapp.feature.listing.models.MoviesResponse
import com.movieapp.feature.listing.repository.HomeRepository
import com.movieapp.network.Resource
import jakarta.inject.Inject
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.launch

@OptIn(FlowPreview::class)
class HomeViewModel @Inject constructor(
    private val repository: HomeRepository
) : ViewModel() {

    val trendingMovies: StateFlow<Resource<MoviesResponse?>> = repository.trendingMovies
    
    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery.asStateFlow()
    
    private val _filteredMovies = MutableStateFlow<ArrayList<Movie>?>(null)
    val filteredMovies: StateFlow<ArrayList<Movie>?> = _filteredMovies.asStateFlow()

    init {
        observeSearchQuery()
        observeTrendingMovies()
    }

    fun getTrendingMovies() {
        viewModelScope.launch {
            repository.getTrendingMovies()
        }
    }

    fun updateSearchQuery(query: String) {
        _searchQuery.value = query
    }

    private fun observeSearchQuery() {
        viewModelScope.launch {
            _searchQuery
                .debounce(500)
                .collect { query ->
                    filterMovies(query)
                }
        }
    }

    private fun observeTrendingMovies() {
        viewModelScope.launch {
            trendingMovies.collect { resource ->
                if (resource is Resource.Success) {
                    filterMovies(_searchQuery.value)
                }
            }
        }
    }

    private fun filterMovies(query: String) {
        val currentMovies = (trendingMovies.value as? Resource.Success)?.data?.listOfMovies
        
        _filteredMovies.value = when {
            currentMovies.isNullOrEmpty() -> null
            query.length >= 3 -> {
                val filtered = currentMovies.filter { movie ->
                    movie.title?.contains(query, ignoreCase = true) == true
                }
                if (filtered.isEmpty()) null else ArrayList(filtered)
            }
            else -> currentMovies
        }
    }
}