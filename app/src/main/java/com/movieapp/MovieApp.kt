package com.movieapp

import android.app.Application
import com.movieapp.di.component.AppComponent
import com.movieapp.di.component.DaggerAppComponent
import com.movieapp.di.module.ContextModule

class MovieApp : Application() {
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .contextModule(ContextModule(this))
            .build()
    }
}