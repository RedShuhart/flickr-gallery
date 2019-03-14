package com.iyushchuk.flickrgallery.features.ui.detailedphotos

import com.arellomobile.mvp.InjectViewState
import com.iyushchuk.flickrgallery.core.navigation.AppRouter
import com.iyushchuk.flickrgallery.features.common.mvp.BaseMvpPresenter
import com.iyushchuk.flickrgallery.features.ui.feed.FeedHolder
import javax.inject.Inject

@InjectViewState
class DetailedPhotosHolderPresenter @Inject internal constructor(
    private val holder: DetailedPhotosHolder,
    private val router: AppRouter
) : BaseMvpPresenter<DetailedPhotosHolderView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.showPhotos(holder)
    }

    fun goBack() {
        router.openFeedCardsScreen(FeedHolder(holder.photos.toMutableList()))
    }
}