package com.example.flickrgallery.core.di.util

import com.example.flickrgallery.core.di.AppScope
import com.example.flickrgallery.core.schedulers.AppRxSchedulers
import com.example.flickrgallery.core.schedulers.RxSchedulers
import dagger.Module
import dagger.Provides

@Module
class SchedulersModule {

    @AppScope
    @Provides
    internal fun provideRxSchedulers(): RxSchedulers = AppRxSchedulers()
}
