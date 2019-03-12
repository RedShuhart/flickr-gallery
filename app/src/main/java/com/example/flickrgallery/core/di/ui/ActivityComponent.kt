package com.example.flickrgallery.core.di.ui

import com.example.flickrgallery.core.di.ui.fragments.*
import com.example.flickrgallery.features.common.BaseActivity
import com.example.flickrgallery.features.ui.MainActivity
import dagger.Subcomponent

@UIScope
@Subcomponent(modules = [ActivityModule::class])
interface ActivityComponent {

    operator fun plus(module: SplashModule): SplashComponent
    operator fun plus(module: FeedModule): FeedComponent
    operator fun plus(module: PhotoModule): PhotoComponent

    fun inject(baseActivity: BaseActivity)
    fun inject(mainActivity: MainActivity)
}