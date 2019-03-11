package com.example.flickrgallery.api.models

import java.time.LocalDateTime

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
)