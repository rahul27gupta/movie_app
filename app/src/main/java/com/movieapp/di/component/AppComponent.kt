package com.movieapp.di.component

import com.movieapp.di.module.ContextModule
import com.movieapp.di.module.DataSourceModule
import com.movieapp.di.module.NetworkModule
import com.movieapp.di.module.RepositoryModule
import com.movieapp.di.module.ViewModelModule
import com.movieapp.feature.listing.ui.activity.HomeActivity
import com.movieapp.feature.listing.ui.activity.MovieDetailActivity
import com.movieapp.feature.listing.viewModels.HomeViewModelFactory
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [ContextModule::class,
        NetworkModule::class,
        DataSourceModule::class,
        RepositoryModule::class,
        ViewModelModule::class]
)
interface AppComponent {
    fun inject(activity: HomeActivity)
    fun inject(activity: MovieDetailActivity)
    fun getHomeViewModel(): HomeViewModelFactory
}