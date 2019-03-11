package com.example.flickrgallery.api.models

data class FlickrFeed (
    val title: String,
    val link: String,
    val description: String,
    val modified: String,
    val generator: String,
    val items: List<FlickrImage>
)