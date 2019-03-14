package com.iyushchuk.flickrgallery.core.di.util

import android.content.Context
import com.iyushchuk.flickrgallery.core.di.AppScope
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
