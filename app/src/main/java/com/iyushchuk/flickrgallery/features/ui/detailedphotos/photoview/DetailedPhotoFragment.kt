package com.iyushchuk.flickrgallery.features.ui.detailedphotos.photoview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.iyushchuk.flickrgallery.R
import com.iyushchuk.flickrgallery.core.api.models.FlickrImage
import com.iyushchuk.flickrgallery.features.common.util.loadImage
import com.github.chrisbanes.photoview.PhotoView

class DetailedPhotoFragment : Fragment() {

    lateinit var flickrImage: FlickrImage
    lateinit var imageView: PhotoView

    override fun onCreate(savedInstanceState: Bundle?) {
        flickrImage = arguments!!.getSerializable(FLICKR_IMAGE) as FlickrImage

        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.photo_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        imageView = view.findViewById(R.id.full_size_photo)
        loadImage(requireContext(), flickrImage, imageView, true)
    }

    companion object {

        private const val FLICKR_IMAGE = "FLICKR_IMAGE"

        fun newInstance(flickrImage: FlickrImage): DetailedPhotoFragment {

            val args = Bundle()
            args.putSerializable(FLICKR_IMAGE, flickrImage)

            val fragment = DetailedPhotoFragment()
            fragment.arguments = args
            return fragment
        }
    }
}