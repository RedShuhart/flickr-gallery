package com.example.flickrgallery.features.ui.splash

import com.example.flickrgallery.features.common.mvp.BaseMvpPresenter
import com.example.flickrgallery.core.navigation.AppRouter
import com.example.flickrgallery.core.schedulers.RxSchedulers
import io.reactivex.Single
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class SplashPresenter @Inject internal constructor(
    private val rxSchedulers: RxSchedulers,
    private val router: AppRouter
): BaseMvpPresenter<SplashView>() {

    // TODO: Maybe we can preload feed here
    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        Single.just("")
            .delay(500, TimeUnit.MILLISECONDS)
            .compose(rxSchedulers.computationToMainSingle())
            .subscribe{ _ -> router.openFeedCardsScreen() }
            .unsubscribeOnDestroy()
    }
}