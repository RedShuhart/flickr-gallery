package com.example.flickrgallery.features.ui.feed

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.example.flickrgallery.core.api.models.FlickrImage
import com.example.flickrgallery.features.common.mvp.BaseMvpView
import com.example.flickrgallery.features.common.mvp.ProgressMvpView


interface FeedView: BaseMvpView, ProgressMvpView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showFeed(feed: List<FlickrImage>)

}