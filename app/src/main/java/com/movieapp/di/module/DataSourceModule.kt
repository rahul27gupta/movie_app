package com.movieapp.di.module

import com.movieapp.feature.listing.dataSource.HomeDataSource
import com.movieapp.feature.listing.dataSource.HomeDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
abstract class DataSourceModule {

    @Binds
    @Singleton
    abstract fun provideHomeDataSource(homeDataSource: HomeDataSourceImpl): HomeDataSource

}