package com.example.flickrgallery.features.ui.photo

import com.arellomobile.mvp.InjectViewState
import com.example.flickrgallery.core.navigation.AppRouter
import com.example.flickrgallery.features.common.mvp.BaseMvpPresenter
import javax.inject.Inject

@InjectViewState
class PhotoPresenter @Inject internal constructor(
    private val router: AppRouter
) : BaseMvpPresenter<PhotoView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.showPhoto()
    }

    fun goBack() {
        router.openFeedCardsScreen()
    }
}