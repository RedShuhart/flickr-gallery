package com.example.flickrgallery

import androidx.multidex.MultiDexApplication
import com.example.flickrgallery.core.di.AppComponent
import com.example.flickrgallery.core.di.DaggerAppComponent
import com.example.flickrgallery.core.di.util.AppContextModule


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