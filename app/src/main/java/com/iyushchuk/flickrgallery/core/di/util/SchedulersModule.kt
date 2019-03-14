package com.iyushchuk.flickrgallery.core.di.util

import com.iyushchuk.flickrgallery.core.di.AppScope
import com.iyushchuk.flickrgallery.core.schedulers.AppRxSchedulers
import com.iyushchuk.flickrgallery.core.schedulers.RxSchedulers
import dagger.Module
import dagger.Provides

@Module
class SchedulersModule {

    @AppScope
    @Provides
    internal fun provideRxSchedulers(): RxSchedulers = AppRxSchedulers()
}
