package com.example.flickrgallery.core.di.ui.fragments

import com.example.flickrgallery.features.ui.feed.FeedFragment
import com.example.flickrgallery.features.ui.photo.PhotoFragment
import com.example.flickrgallery.features.ui.splash.SplashFragment
import dagger.Subcomponent

@Subcomponent(modules = [SplashModule::class])
interface SplashComponent {
    fun inject(fragment: SplashFragment)
}

@Subcomponent(modules = [FeedModule::class])
interface FeedComponent {
    fun inject(fragment: FeedFragment)
}

@Subcomponent(modules = [PhotoModule::class])
interface PhotoComponent {
    fun inject(fragment: PhotoFragment)
}