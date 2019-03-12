package com.example.flickrgallery.features.ui.feed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.core.widget.ContentLoadingProgressBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.flickrgallery.R
import com.example.flickrgallery.core.api.models.FlickrImage
import com.example.flickrgallery.core.di.ui.fragments.FragmentModule
import com.example.flickrgallery.features.common.mvp.BaseMvpFragment
import javax.inject.Inject

class FeedFragment : BaseMvpFragment(), FeedView {

    @Inject
    @InjectPresenter
    lateinit var presenter: FeedPresenter

    @ProvidePresenter
    fun providePresenter(): FeedPresenter = presenter

    lateinit var feedView: RecyclerView
    lateinit var progressBar: ContentLoadingProgressBar

    private var feedAdapter: FeedAdapter = FeedAdapter(onClickListener = this::onImageClick)

    override fun onCreate(savedInstanceState: Bundle?) {
        getActivityComponent().plus(FragmentModule()).inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.feed_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        progressBar = view.findViewById(R.id.progressBar)
        feedView = view.findViewById(R.id.feed)
        feedView.layoutManager = LinearLayoutManager(requireContext())
    }

    override fun showFeed(images: List<FlickrImage>) {
        feedAdapter.data.clear()
        feedAdapter.data.addAll(images)
        feedAdapter.notifyDataSetChanged()
    }

    override fun showProgress() {
        progressBar.show()
    }

    override fun hideProgress() {
        progressBar.hide()
    }

    private fun onImageClick(image: FlickrImage) {
        presenter.onFeedItemClick(image)
    }

    companion object {
        fun newInstance(): FeedFragment {
            val fragment = FeedFragment()
            fragment.arguments = Bundle()
            return fragment
        }
    }
}