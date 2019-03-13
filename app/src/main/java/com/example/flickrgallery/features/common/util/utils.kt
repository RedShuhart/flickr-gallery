package com.example.flickrgallery.features.common.util

import android.content.Context
import androidx.appcompat.widget.AppCompatImageView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.example.flickrgallery.core.api.models.FlickrImage

fun loadImage(context: Context, flickrImage: FlickrImage, imageView: AppCompatImageView, fullSize: Boolean = false) =
    Glide.with(context)
        .load(flickrImage.getUrl(fullSize))
        .placeholder(createCircularProgressDrawable(context))
        .into(imageView)

internal fun FlickrImage.getUrl(fullSize: Boolean = false) = media.m.apply {
    if (fullSize)  replace(regex = Regex("(.{2})(?=.jpg+)"), replacement = "_z")
}

internal fun createCircularProgressDrawable(context: Context) = CircularProgressDrawable(context).apply {
    strokeWidth = 10f
    centerRadius = 60f
    start()
}