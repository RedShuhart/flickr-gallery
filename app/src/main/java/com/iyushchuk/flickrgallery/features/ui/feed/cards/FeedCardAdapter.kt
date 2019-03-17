package com.iyushchuk.flickrgallery.features.ui.feed.cards

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.iyushchuk.flickrgallery.R
import com.iyushchuk.flickrgallery.core.api.models.FlickrImage
import com.iyushchuk.flickrgallery.features.common.util.ImageSize
import com.iyushchuk.flickrgallery.features.common.util.loadImage
import com.iyushchuk.flickrgallery.features.common.util.printImageDate

class FeedCardAdapter(
    private val data: MutableList<FlickrImage> = mutableListOf(),
    val onClickListener: (position: Int) -> Unit = {}
): RecyclerView.Adapter<FeedCardAdapter.Companion.ViewHolder>(), MutableList<FlickrImage> by data {

    companion object {

        class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
            val image = itemView.findViewById<AppCompatImageView>(R.id.flickr_image)
            val title = itemView.findViewById<AppCompatTextView>(R.id.title)
            val published = itemView.findViewById<AppCompatTextView>(R.id.published)
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentImage = data[position]

        holder.title.text = currentImage.title

        holder.published.text = printImageDate(currentImage)

        loadImage(holder.itemView.context, currentImage, holder.image, ImageSize.LARGER)

        holder.image.setOnClickListener{ onClickListener(position) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.feed_card_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = data.size

}