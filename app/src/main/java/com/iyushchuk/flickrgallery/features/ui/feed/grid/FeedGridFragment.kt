package com.iyushchuk.flickrgallery.features.ui.feed.grid

import android.os.Bundle
import android.view.*
import android.widget.GridView
import androidx.appcompat.widget.SearchView
import androidx.core.widget.ContentLoadingProgressBar
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.iyushchuk.flickrgallery.R
import com.iyushchuk.flickrgallery.core.api.models.FlickrImage
import com.iyushchuk.flickrgallery.core.di.ui.fragments.FeedGridModule
import com.iyushchuk.flickrgallery.features.common.mvp.BaseMvpFragment
import com.iyushchuk.flickrgallery.features.ui.feed.FeedHolder
import com.iyushchuk.flickrgallery.features.ui.feed.FeedPresenter
import com.iyushchuk.flickrgallery.features.ui.feed.FeedView
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
        val feedHolder = arguments!!.getSerializable(FEED_HOLDER) as FeedHolder
        getActivityComponent().plus(FeedGridModule(feedHolder)).inject(this)
        setHasOptionsMenu(true)
        super.onCreate(savedInstanceState)

        feedAdapter = FeedGridAdapter(context = requireContext(), onClickListener = this::onImageClick)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(com.iyushchuk.flickrgallery.R.layout.feed_grid_fragment, container, false)
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

        val searchView = SearchView(getBaseActivity().supportActionBar?.themedContext ?: context)
        menu.findItem(R.id.search).apply {
            setShowAsAction(MenuItem.SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW or MenuItem.SHOW_AS_ACTION_IF_ROOM)
            actionView = searchView
        }

        searchView.setOnQueryTextListener(object :  SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                presenter.loadFeed(query)
                return false
            }
            override fun onQueryTextChange(newText: String): Boolean {
                return false
            }
        })
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

        private const val FEED_HOLDER = "FEED_HOLDER"

        fun newInstance(feedHolder: FeedHolder): FeedGridFragment {

            val args = Bundle()
            args.putSerializable(FEED_HOLDER, feedHolder)

            val fragment = FeedGridFragment()
            fragment.arguments = args
            return fragment
        }
    }
}