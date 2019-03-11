package com.example.flickrgallery

import androidx.multidex.MultiDexApplication
import com.example.flickrgallery.di.AppComponent
import com.example.flickrgallery.di.DaggerAppComponent
import com.example.flickrgallery.di.core.AppContextModule


class FlickrApp : MultiDexApplication() {

    lateinit var appComponent: AppComponent
        private set

    override fun onCreate() {
        super.onCreate()
        initAppComponent()
    }

    private fun initAppComponent() {
        appComponent = DaggerAppComponent.builder().appContextModule(AppContextModule(this)).build()
    }
}