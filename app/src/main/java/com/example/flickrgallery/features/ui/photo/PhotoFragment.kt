package com.example.flickrgallery.features.ui.photo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.bumptech.glide.Glide
import com.example.flickrgallery.R
import com.example.flickrgallery.core.api.models.FlickrImage
import com.example.flickrgallery.core.di.ui.fragments.PhotoModule
import com.example.flickrgallery.features.common.mvp.BaseMvpFragment
import javax.inject.Inject

class PhotoFragment : BaseMvpFragment(), PhotoView {

    @Inject
    @InjectPresenter
    lateinit var presenter: PhotoPresenter

    @ProvidePresenter
    fun providePresenter(): PhotoPresenter = presenter

    lateinit var flickrImage: FlickrImage
    lateinit var imageView: AppCompatImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        flickrImage = arguments!!.getSerializable(FLICKR_IMAGE) as FlickrImage

        getActivityComponent().plus(PhotoModule()).inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.photo_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        imageView = view.findViewById(R.id.full_size_photo)
    }

    override fun showPhoto() {
        Glide.with(requireContext())
            .load(flickrImage.media.m.replace("_m", "_z"))
            .into(imageView)
    }

    companion object {

        private const val FLICKR_IMAGE = "FLICKR_IMAGE"

        fun newInstance(flickrImage: FlickrImage): PhotoFragment {

            val args = Bundle()
            args.putSerializable(FLICKR_IMAGE, flickrImage)

            val fragment = PhotoFragment()
            fragment.arguments = args
            return fragment
        }
    }
}