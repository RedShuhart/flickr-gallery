package com.iyushchuk.flickrgallery.features.ui.feed

import com.iyushchuk.flickrgallery.core.api.models.FlickrImage
import java.io.Serializable

data class FeedHolder(
    val feed: MutableList<FlickrImage>
): Serializable