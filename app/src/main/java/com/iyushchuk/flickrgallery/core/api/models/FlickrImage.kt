package com.iyushchuk.flickrgallery.core.api.models

import java.io.Serializable

data class FlickrImage (
    val title: String,
    val link: String,
    val media: FlickrMediaHolder,
    val date_taken: String,
    val description: String,
    val published: String,
    val author: String,
    val author_id: String,
    val tags: String
): Serializable