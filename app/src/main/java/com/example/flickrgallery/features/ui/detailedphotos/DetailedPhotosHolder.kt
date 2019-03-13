package com.example.flickrgallery.features.ui.detailedphotos

import com.example.flickrgallery.core.api.models.FlickrImage
import java.io.Serializable

data class DetailedPhotosHolder(
    val position: Int = 0,
    val photos: List<FlickrImage>
): Serializable