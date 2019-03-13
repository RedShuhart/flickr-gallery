package com.example.flickrgallery.features.ui.feed.cards

import android.os.Bundle
import android.view.*
import androidx.core.widget.ContentLoadingProgressBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.flickrgallery.R
import com.example.flickrgallery.core.api.models.FlickrImage
import com.example.flickrgallery.core.di.ui.fragments.FeedCardsModule
import com.example.flickrgallery.features.common.mvp.BaseMvpFragment
import javax.inject.Inject
import android.view.MenuInflater
import com.example.flickrgallery.features.ui.feed.FeedPresenter
import com.example.flickrgallery.features.ui.feed.FeedView


class FeedCardsFragment : BaseMvpFragment(), FeedView {

    @Inject
    @InjectPresenter
    lateinit var presenter: FeedPresenter

    @ProvidePresenter
    fun providePresenter(): FeedPresenter = presenter

    private lateinit var feedView: RecyclerView
    private lateinit var progressBar: ContentLoadingProgressBar

    private val feedCardAdapter: FeedCardAdapter =
        FeedCardAdapter(onClickListener = this::onImageClick)

    override fun onCreate(savedInstanceState: Bundle?) {
        getActivityComponent().plus(FeedCardsModule()).inject(this)
        setHasOptionsMenu(true)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(com.example.flickrgallery.R.layout.feed_cards_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        progressBar = view.findViewById(R.id.progressBar)
        feedView = view.findViewById(R.id.feed)

        initFeedView()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.feed_cards_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.grid -> {
                presenter.goToGridView()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun showFeed(images: List<FlickrImage>) {
        reloadCards(images)
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

    private fun reloadCards(data: List<FlickrImage>) {
        feedCardAdapter.clear()
        feedCardAdapter.addAll(data)
        feedCardAdapter.notifyDataSetChanged()
    }

    private fun initFeedView() {
        feedView.adapter = feedCardAdapter
        feedView.layoutManager = LinearLayoutManager(requireContext())
    }

    companion object {
        fun newInstance(): FeedCardsFragment {
            val fragment = FeedCardsFragment()
            fragment.arguments = Bundle()
            return fragment
        }
    }
}