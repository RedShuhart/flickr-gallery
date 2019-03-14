package com.iyushchuk.flickrgallery.features.ui.feed

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.iyushchuk.flickrgallery.core.api.models.FlickrImage
import com.iyushchuk.flickrgallery.features.common.mvp.BaseMvpView
import com.iyushchuk.flickrgallery.features.common.mvp.ProgressMvpView


interface FeedView: BaseMvpView, ProgressMvpView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showFeed(feed: List<FlickrImage>)

}