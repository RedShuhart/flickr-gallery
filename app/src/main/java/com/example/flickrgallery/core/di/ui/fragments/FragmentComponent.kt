package com.example.flickrgallery.core.di.ui.fragments

import com.example.flickrgallery.features.ui.splash.SplashFragment
import dagger.Subcomponent

@Subcomponent(modules = [FragmentModule::class])
interface FragmentComponent {
    fun inject(fragment: SplashFragment)
}