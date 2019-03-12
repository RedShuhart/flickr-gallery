package com.example.flickrgallery.features.common.util

import android.content.Context
import androidx.appcompat.widget.AppCompatImageView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.example.flickrgallery.core.api.models.FlickrImage

fun loadImage(context: Context, flickrImage: FlickrImage, imageView: AppCompatImageView) {

    val circularProgressDrawable = CircularProgressDrawable(context).apply {
        strokeWidth = 10f
        centerRadius = 60f
        start()
    }

    Glide.with(context)
        .load(flickrImage.media.m)
        .placeholder(circularProgressDrawable)
        .into(imageView)
}