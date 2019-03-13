package com.example.flickrgallery.features.ui.detailedphotos

import com.arellomobile.mvp.InjectViewState
import com.example.flickrgallery.core.navigation.AppRouter
import com.example.flickrgallery.features.common.mvp.BaseMvpPresenter
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
        router.openFeedCardsScreen()
    }
}