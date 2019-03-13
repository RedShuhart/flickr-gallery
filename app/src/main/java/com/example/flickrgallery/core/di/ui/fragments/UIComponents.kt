package com.example.flickrgallery.core.di.ui.fragments

import com.example.flickrgallery.features.ui.feed.cards.FeedCardsFragment
import com.example.flickrgallery.features.ui.feed.grid.FeedGridFragment
import com.example.flickrgallery.features.ui.detailedphotos.photoview.DetailedPhotoFragment
import com.example.flickrgallery.features.ui.detailedphotos.DetailedPhotosHolderFragment
import com.example.flickrgallery.features.ui.splash.SplashFragment
import dagger.Subcomponent

@Subcomponent(modules = [SplashModule::class])
interface SplashComponent {
    fun inject(fragment: SplashFragment)
}

@Subcomponent(modules = [FeedCardsModule::class])
interface FeedCardsComponent {
    fun inject(fragment: FeedCardsFragment)
}

@Subcomponent(modules = [FeedGridModule::class])
interface FeedGridComponent {
    fun inject(fragment: FeedGridFragment)
}

@Subcomponent(modules = [DetailedPhotosHolderModule::class])
interface DetailedPhotosHolderComponent {
    fun inject(fragment: DetailedPhotosHolderFragment)
}