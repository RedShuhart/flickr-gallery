package com.example.flickrgallery.features.ui.feed.grid

import android.os.Bundle
import android.view.*
import android.widget.GridView
import androidx.core.widget.ContentLoadingProgressBar
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.flickrgallery.R
import com.example.flickrgallery.core.api.models.FlickrImage
import com.example.flickrgallery.core.di.ui.fragments.FeedGridModule
import com.example.flickrgallery.features.common.mvp.BaseMvpFragment
import com.example.flickrgallery.features.ui.feed.FeedPresenter
import com.example.flickrgallery.features.ui.feed.FeedView
import java.text.FieldPosition
import javax.inject.Inject


class FeedGridFragment : BaseMvpFragment(), FeedView {

    @Inject
    @InjectPresenter
    lateinit var presenter: FeedPresenter

    @ProvidePresenter
    fun providePresenter(): FeedPresenter = presenter

    private lateinit var feedView: GridView
    private lateinit var progressBar: ContentLoadingProgressBar

    private lateinit var feedAdapter: FeedGridAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        getActivityComponent().plus(FeedGridModule()).inject(this)
        setHasOptionsMenu(true)
        super.onCreate(savedInstanceState)

        feedAdapter = FeedGridAdapter(context = requireContext(), onClickListener = this::onImageClick)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(com.example.flickrgallery.R.layout.feed_grid_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        progressBar = view.findViewById(R.id.progressBar)
        feedView = view.findViewById(R.id.feed_grid_view)
        feedView.adapter = feedAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.feed_grid_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.card -> {
                presenter.goToCardView()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun showFeed(images: List<FlickrImage>) {
        feedAdapter.clear()
        feedAdapter.addAll(images)
        feedAdapter.notifyDataSetChanged()
    }

    override fun showProgress() {
        progressBar.show()
    }

    override fun hideProgress() {
        progressBar.hide()
    }

    private fun onImageClick(position: Int) {
        presenter.onFeedItemClick(position)
    }


    companion object {
        fun newInstance(): FeedGridFragment {
            val fragment = FeedGridFragment()
            fragment.arguments = Bundle()
            return fragment
        }
    }
}