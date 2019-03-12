package com.example.flickrgallery.features.ui.photo

import com.arellomobile.mvp.viewstate.strategy.SingleStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.example.flickrgallery.features.common.mvp.BaseMvpView

interface PhotoView: BaseMvpView {

    @StateStrategyType(SingleStateStrategy::class)
    fun showPhoto()
}