package com.example.flickrgallery.features.ui.feed.grid

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.appcompat.widget.AppCompatImageView
import com.example.flickrgallery.R
import com.example.flickrgallery.core.api.models.FlickrImage
import com.example.flickrgallery.features.common.util.loadImage

class FeedGridAdapter(
    val context: Context,
    val data: MutableList<FlickrImage> = mutableListOf(),
    val onClickListener: (item: FlickrImage) -> Unit = {}) : BaseAdapter(), MutableList<FlickrImage> by data {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view: View
        val viewHolder: ViewHolder
        if (convertView == null) {
            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            view = inflater.inflate(R.layout.feed_grid_item, null)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }

        val currentImage = data[position]

        loadImage(context, currentImage, viewHolder.imageView)

        viewHolder.imageView.setOnClickListener{onClickListener(currentImage)}

        return view
    }

    override fun getItem(i: Int): FlickrImage {
        return data[i]
    }

    override fun getItemId(i: Int): Long {
        return i.toLong()
    }

    override fun getCount(): Int {
        return data.size
    }

    override fun isEmpty(): Boolean {
        return data.isEmpty()
    }

    private class ViewHolder(view: View) {
        val imageView = view.findViewById<AppCompatImageView>(R.id.feed_grid_photo)
    }


}