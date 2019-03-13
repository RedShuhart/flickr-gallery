package com.example.flickrgallery.core.di.ui.fragments

import com.example.flickrgallery.features.ui.detailedphotos.DetailedPhotosHolder
import dagger.Module
import dagger.Provides

@Module
class SplashModule

@Module
class FeedCardsModule

@Module
class FeedGridModule

@Module
class DetailedPhotosHolderModule(private val photosHolder: DetailedPhotosHolder) {
    @Provides
    internal fun providePhotosHolder(): DetailedPhotosHolder = photosHolder
}