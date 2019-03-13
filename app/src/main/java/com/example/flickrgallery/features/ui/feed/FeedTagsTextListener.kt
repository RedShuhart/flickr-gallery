package com.example.flickrgallery.features.ui.feed

import android.widget.SearchView

class FeedTagsTextListener(val onChangeListener: (text: String) -> Unit = {}): SearchView.OnQueryTextListener {
    override fun onQueryTextSubmit(query: String): Boolean {
        onChangeListener(query)
        return false
    }

    override fun onQueryTextChange(newText: String): Boolean {
        return false
    }
}