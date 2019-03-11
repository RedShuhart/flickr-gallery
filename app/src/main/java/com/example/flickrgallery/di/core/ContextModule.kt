package com.example.flickrgallery.di.core

import android.content.Context
import com.example.flickrgallery.di.AppScope
import dagger.Module
import dagger.Provides

@Module
class AppContextModule(private val context: Context) {

    @AppScope
    @Provides
    internal fun provideAppContext(): Context {
        return context
    }
}
