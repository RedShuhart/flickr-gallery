package com.iyushchuk.flickrgallery.core.di.ui.fragments

import com.iyushchuk.flickrgallery.features.ui.detailedphotos.DetailedPhotosHolder
import com.iyushchuk.flickrgallery.features.ui.feed.FeedHolder
import dagger.Module
import dagger.Provides

@Module
class SplashModule

@Module
class FeedCardsModule(private val feedHolder: FeedHolder) {
    @Provides
    internal fun provideFeedHolder(): FeedHolder = feedHolder
}

@Module
class FeedGridModule(private val feedHolder: FeedHolder) {
    @Provides
    internal fun provideFeedHolder(): FeedHolder = feedHolder
}

@Module
class DetailedPhotosHolderModule(private val photosHolder: DetailedPhotosHolder) {
    @Provides
    internal fun providePhotosHolder(): DetailedPhotosHolder = photosHolder
}