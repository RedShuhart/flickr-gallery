package com.iyushchuk.flickrgallery.features.ui.detailedphotos

import com.arellomobile.mvp.viewstate.strategy.SingleStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.iyushchuk.flickrgallery.features.common.mvp.BaseMvpView

interface DetailedPhotosHolderView: BaseMvpView {

    @StateStrategyType(SingleStateStrategy::class)
    fun showPhotos(holder: DetailedPhotosHolder)
}