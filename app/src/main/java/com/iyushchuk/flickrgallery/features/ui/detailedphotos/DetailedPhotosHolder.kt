package com.iyushchuk.flickrgallery.features.ui.detailedphotos

import com.iyushchuk.flickrgallery.core.api.models.FlickrImage
import java.io.Serializable

data class DetailedPhotosHolder(
    val position: Int = 0,
    val photos: List<FlickrImage>
): Serializable