package com.iyushchuk.flickrgallery

import androidx.multidex.MultiDexApplication
import com.iyushchuk.flickrgallery.core.di.AppComponent
import com.iyushchuk.flickrgallery.core.di.DaggerAppComponent
import com.iyushchuk.flickrgallery.core.di.util.AppContextModule


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