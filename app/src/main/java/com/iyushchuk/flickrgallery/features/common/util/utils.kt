package com.iyushchuk.flickrgallery.features.common.util

import android.content.Context
import androidx.appcompat.widget.AppCompatImageView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.iyushchuk.flickrgallery.core.api.models.FlickrImage
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun loadImage(context: Context, flickrImage: FlickrImage, imageView: AppCompatImageView, fullSize: Boolean = false) =
    Glide.with(context)
        .load(flickrImage.getUrl(fullSize))
        .placeholder(createCircularProgressDrawable(context))
        .into(imageView)


fun printImageDate(flickrImage: FlickrImage): String {
    val date = LocalDateTime.parse(flickrImage.published, dateFormat)
    return date.format(printFormatter)
}

internal fun FlickrImage.getUrl(fullSize: Boolean = false) = media.m.apply {
    // TODO: Regex isn't working properly try another
    // val regex  = Regex("(.{2})(?=.jpg+)")

    if (fullSize) replace("_m", "_z")
}

internal fun createCircularProgressDrawable(context: Context) = CircularProgressDrawable(context).apply {
    strokeWidth = 10f
    centerRadius = 60f
    start()
}

internal val dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'")
internal val printFormatter = DateTimeFormatter.ofPattern("d MMM yyyy HH:mm")