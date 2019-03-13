package com.example.flickrgallery.features.ui.detailedphotos.photoview

import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.flickrgallery.core.api.models.FlickrImage

class DetailedPhotosPagerAdapter(
    val fm: FragmentManager?,
    val data: List<FlickrImage> = mutableListOf()
): FragmentPagerAdapter(fm), List<FlickrImage> by data {

    override fun getCount() = data.size

    override fun getItem(position: Int) = DetailedPhotoFragment.newInstance(data[position])
}