package com.example.flickrgallery.features.ui.feed

import com.arellomobile.mvp.InjectViewState
import com.example.flickrgallery.core.api.FlickrApi
import com.example.flickrgallery.core.api.models.FlickrImage
import com.example.flickrgallery.core.navigation.AppRouter
import com.example.flickrgallery.core.schedulers.RxSchedulers
import com.example.flickrgallery.features.common.mvp.BaseMvpPresenter
import com.example.flickrgallery.features.ui.detailedphotos.DetailedPhotosHolder
import timber.log.Timber
import javax.inject.Inject

@InjectViewState
class FeedPresenter @Inject internal constructor(
    private val flickrApi: FlickrApi,
    private val rxSchedulers: RxSchedulers,
    private val router: AppRouter
) : BaseMvpPresenter<FeedView>() {

    private val feed = mutableListOf<FlickrImage>()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        loadFeed()
    }

    private fun loadFeed(layout: String = "CARD") {
        flickrApi.getFeed()
            .compose(rxSchedulers.ioToMain())
            .progress()
            .subscribe(
                { result ->
                    feed.clear()
                    feed.addAll(result.items)
                    viewState.showFeed(feed)
                },
                { throwable -> Timber.e(throwable) }
            ).unsubscribeOnDestroy()
    }

    fun onFeedItemClick(position: Int) {
        val holder = DetailedPhotosHolder(position, feed)
        router.openDetailedPhotosHolderScreen(holder)
    }

    fun goToGridView() {
        router.openFeedGridScreen()
    }

    fun goToCardView() {
        router.openFeedCardsScreen()
    }
}