package com.iyushchuk.flickrgallery.features.ui.splash

import com.iyushchuk.flickrgallery.core.api.FlickrApi
import com.iyushchuk.flickrgallery.features.common.mvp.BaseMvpPresenter
import com.iyushchuk.flickrgallery.core.navigation.AppRouter
import com.iyushchuk.flickrgallery.core.schedulers.RxSchedulers
import com.iyushchuk.flickrgallery.features.ui.feed.FeedHolder
import timber.log.Timber
import javax.inject.Inject

class SplashPresenter @Inject internal constructor(
    private val flickrApi: FlickrApi,
    private val rxSchedulers: RxSchedulers,
    private val router: AppRouter
): BaseMvpPresenter<SplashView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        flickrApi.getFeed()
            .compose(rxSchedulers.ioToMain())
            .progress()
            .subscribe(
                { result -> router.openFeedCardsScreen(FeedHolder(result.items.toMutableList())) },
                { throwable -> Timber.e(throwable) }
            ).unsubscribeOnDestroy()
    }
}