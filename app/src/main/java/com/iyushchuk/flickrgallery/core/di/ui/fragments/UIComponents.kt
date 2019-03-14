package com.iyushchuk.flickrgallery.core.di.ui.fragments

import com.iyushchuk.flickrgallery.features.ui.feed.cards.FeedCardsFragment
import com.iyushchuk.flickrgallery.features.ui.feed.grid.FeedGridFragment
import com.iyushchuk.flickrgallery.features.ui.detailedphotos.DetailedPhotosHolderFragment
import com.iyushchuk.flickrgallery.features.ui.splash.SplashFragment
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