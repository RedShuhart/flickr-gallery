package com.example.flickrgallery.di.core

import com.example.flickrgallery.di.AppScope
import com.example.flickrgallery.schedulers.AppRxSchedulers
import com.example.flickrgallery.schedulers.RxSchedulers
import dagger.Module
import dagger.Provides

@Module
class SchedulersModule {

    @AppScope
    @Provides
    internal fun provideRxSchedulers(): RxSchedulers = AppRxSchedulers()
}
