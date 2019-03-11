package com.example.flickrgallery.features.ui.splash

import com.example.flickrgallery.features.common.mvp.BaseMvpPresenter
import com.example.flickrgallery.core.navigation.AppRouter
import com.example.flickrgallery.core.schedulers.RxSchedulers
import javax.inject.Inject

class SplashPresenter @Inject internal constructor(
    private val schedulers: RxSchedulers,
    private val router: AppRouter
): BaseMvpPresenter<SplashView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        // TODO: Navigate to feed fragment
        //router.navigateTo()
    }
}