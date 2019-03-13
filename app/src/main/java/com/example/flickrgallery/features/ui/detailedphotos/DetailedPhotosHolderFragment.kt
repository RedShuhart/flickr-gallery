package com.example.flickrgallery.features.ui.detailedphotos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.flickrgallery.R
import com.example.flickrgallery.core.api.models.FlickrImage
import com.example.flickrgallery.core.di.ui.fragments.DetailedPhotosHolderModule
import com.example.flickrgallery.features.common.mvp.BaseMvpFragment
import com.example.flickrgallery.features.ui.detailedphotos.photoview.DetailedPhotoFragment
import com.example.flickrgallery.features.ui.detailedphotos.photoview.DetailedPhotosPagerAdapter
import timber.log.Timber
import javax.inject.Inject

class DetailedPhotosHolderFragment : BaseMvpFragment(), DetailedPhotosHolderView {

    @Inject
    @InjectPresenter
    lateinit var presenter: DetailedPhotosHolderPresenter

    @ProvidePresenter
    fun providePresenter(): DetailedPhotosHolderPresenter = presenter

    lateinit var photoPager: ViewPager
    lateinit var photoPagerAdapter: DetailedPhotosPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        val photosHolder = arguments!!.getSerializable(PHOTOS_HOLDER) as DetailedPhotosHolder
        getActivityComponent().plus(DetailedPhotosHolderModule(photosHolder)).inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.detailed_photos_holder_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        photoPager = view.findViewById(R.id.holder_view_pager)
    }

    override fun showPhotos(holder: DetailedPhotosHolder) {
        initPhotoPager(holder)
    }

    override fun onBackPressed(): Boolean {
        presenter.goBack()
        return true
    }

    private fun initPhotoPager(holder: DetailedPhotosHolder) {
        photoPagerAdapter = DetailedPhotosPagerAdapter(childFragmentManager, holder.photos)
        photoPager.adapter = photoPagerAdapter
        photoPager.setCurrentItem(holder.position, false)
    }

    companion object {

        private const val PHOTOS_HOLDER = "PHOTOS_HOLDER"

        fun newInstance(photosHolder: DetailedPhotosHolder): DetailedPhotosHolderFragment {

            val args = Bundle()
            args.putSerializable(PHOTOS_HOLDER, photosHolder)

            val fragment = DetailedPhotosHolderFragment()
            fragment.arguments = args
            return fragment
        }
    }
}