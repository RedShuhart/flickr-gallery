package com.example.flickrgallery.features.ui.feed

import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.example.flickrgallery.R
import com.example.flickrgallery.core.api.models.FlickrImage
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeFormatter.ISO_INSTANT

class FeedAdapter(val data: MutableList<FlickrImage> = mutableListOf(), val onClickListener: (item: FlickrImage) -> Unit = {}):
    RecyclerView.Adapter<FeedAdapter.Companion.ViewHolder>(), MutableList<FlickrImage> by data {

    companion object {
        class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
            val image = itemView.findViewById<AppCompatImageView>(R.id.flickr_image)
            val title = itemView.findViewById<AppCompatTextView>(R.id.title)
            val published = itemView.findViewById<AppCompatTextView>(R.id.published)
        }
    }

    override fun onBindViewHolder(holder: FeedAdapter.Companion.ViewHolder, position: Int) {
        val currentImage = data[position]

        val circularProgressDrawable = CircularProgressDrawable(holder.itemView.context).apply {
            strokeWidth = 8f
            centerRadius = 50f
            start()
        }

        holder.title.text = currentImage.title
        holder.published.text = LocalDateTime.parse(currentImage.published, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'")).toString()

        Glide.with(holder.itemView.context)
            .load(currentImage.media.m.replace("_m", "_z"))
            .placeholder(circularProgressDrawable)
            .into(holder.image)

        holder.image.setOnClickListener{ onClickListener(currentImage) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedAdapter.Companion.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.feed_item, parent, false)
        return FeedAdapter.Companion.ViewHolder(view)
    }

    override fun getItemCount() = data.size
}