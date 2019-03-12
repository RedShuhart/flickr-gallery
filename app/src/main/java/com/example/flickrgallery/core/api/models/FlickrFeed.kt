package com.example.flickrgallery.core.api.models

import java.io.Serializable

data class FlickrFeed (
    val title: String,
    val link: String,
    val description: String,
    val modified: String,
    val generator: String,
    val items: List<FlickrImage>
): Serializable