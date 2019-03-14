package com.iyushchuk.flickrgallery.features.ui.feed

import com.arellomobile.mvp.InjectViewState
import com.iyushchuk.flickrgallery.core.api.FlickrApi
import com.iyushchuk.flickrgallery.core.navigation.AppRouter
import com.iyushchuk.flickrgallery.core.schedulers.RxSchedulers
import com.iyushchuk.flickrgallery.features.common.mvp.BaseMvpPresenter
import com.iyushchuk.flickrgallery.features.ui.detailedphotos.DetailedPhotosHolder
import timber.log.Timber
import javax.inject.Inject

@InjectViewState
class FeedPresenter @Inject internal constructor(
    private val feedHolder: FeedHolder,
    private val flickrApi: FlickrApi,
    private val rxSchedulers: RxSchedulers,
    private val router: AppRouter
) : BaseMvpPresenter<FeedView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.hideProgress()
        viewState.showFeed(feedHolder.feed)
    }

    fun loadFeed(tags: String = "") {
        flickrApi.getFeed(tags = tags)
            .compose(rxSchedulers.ioToMain())
            .progress()
            .subscribe(
                { result ->
                    feedHolder.feed.clear()
                    feedHolder.feed.addAll(result.items)
                    viewState.showFeed(feedHolder.feed)
                },
                { throwable -> Timber.e(throwable) }
            ).unsubscribeOnDestroy()
    }

    fun onFeedItemClick(position: Int) {
        val holder = DetailedPhotosHolder(position, feedHolder.feed)
        router.openDetailedPhotosHolderScreen(holder)
    }

    fun goToGridView() {
        router.openFeedGridScreen(feedHolder)
    }

    fun goToCardView() {
        router.openFeedCardsScreen(feedHolder)
    }
}