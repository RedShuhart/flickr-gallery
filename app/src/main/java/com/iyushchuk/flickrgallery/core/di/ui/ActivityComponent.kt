package com.iyushchuk.flickrgallery.core.di.ui

import com.iyushchuk.flickrgallery.core.di.ui.fragments.*
import com.iyushchuk.flickrgallery.features.common.BaseActivity
import com.iyushchuk.flickrgallery.features.ui.MainActivity
import dagger.Subcomponent

@UIScope
@Subcomponent(modules = [ActivityModule::class])
interface ActivityComponent {

    operator fun plus(module: SplashModule): SplashComponent
    operator fun plus(module: FeedCardsModule): FeedCardsComponent
    operator fun plus(module: FeedGridModule): FeedGridComponent
    operator fun plus(module: DetailedPhotosHolderModule): DetailedPhotosHolderComponent

    fun inject(baseActivity: BaseActivity)
    fun inject(mainActivity: MainActivity)
}