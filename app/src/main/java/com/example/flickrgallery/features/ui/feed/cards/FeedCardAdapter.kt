package com.example.flickrgallery.features.ui.feed.cards

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.example.flickrgallery.R
import com.example.flickrgallery.core.api.models.FlickrImage
import com.example.flickrgallery.features.common.util.loadImage
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class FeedCardAdapter(val data: MutableList<FlickrImage> = mutableListOf(), val onClickListener: (item: FlickrImage) -> Unit = {}):
    RecyclerView.Adapter<FeedCardAdapter.Companion.ViewHolder>(), MutableList<FlickrImage> by data {

    companion object {

        val dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'")

        class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
            val image = itemView.findViewById<AppCompatImageView>(R.id.flickr_image)
            val title = itemView.findViewById<AppCompatTextView>(R.id.title)
            val published = itemView.findViewById<AppCompatTextView>(R.id.published)
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentImage = data[position]

        holder.title.text = currentImage.title

        holder.published.text = LocalDateTime.parse(currentImage.published,
            dateFormat
        ).toString()

        loadImage(holder.itemView.context, currentImage, holder.image)

        holder.image.setOnClickListener{ onClickListener(currentImage) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.feed_card_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = data.size

}