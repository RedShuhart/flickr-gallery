package com.iyushchuk.flickrgallery.features.common.util

import android.content.Context
import androidx.appcompat.widget.AppCompatImageView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.iyushchuk.flickrgallery.core.api.models.FlickrImage
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun loadImage(context: Context, flickrImage: FlickrImage, imageView: AppCompatImageView, size: ImageSize = ImageSize.MEDIUM) =
    Glide.with(context)
        .load(flickrImage.getUrl(size))
        .placeholder(createCircularProgressDrawable(context))
        .into(imageView)

internal fun FlickrImage.getUrl(size: ImageSize) = media.m.let {
    val regex  = Regex("(.)(?=.jpg+)")

    it.replace(regex, size.tag)
}


fun printImageDate(flickrImage: FlickrImage): String {
    val date = LocalDateTime.parse(flickrImage.published, dateFormat)
    return date.format(printFormatter)
}

internal fun createCircularProgressDrawable(context: Context) = CircularProgressDrawable(context).apply {
    strokeWidth = 10f
    centerRadius = 60f
    start()
}

internal val dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'")
internal val printFormatter = DateTimeFormatter.ofPattern("d MMM yyyy HH:mm")

sealed class ImageSize(val tag: String) {
    object MEDIUM : ImageSize("m")
    object LARGER : ImageSize("z")
    object BIG : ImageSize("b")
}
