package com.example.flickrgallery.features.ui.splash

import com.example.flickrgallery.features.common.mvp.BaseMvpPresenter
import com.example.flickrgallery.core.navigation.AppRouter
import com.example.flickrgallery.core.schedulers.RxSchedulers
import javax.inject.Inject

class SplashPresenter @Inject internal constructor(
    private val router: AppRouter
): BaseMvpPresenter<SplashView>() {

    // TODO: Maybe we can preload feed here
    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.openFeedScreen()
    }
}