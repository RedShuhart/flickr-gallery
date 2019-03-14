package com.iyushchuk.flickrgallery.core.navigation

import androidx.fragment.app.Fragment
import com.iyushchuk.flickrgallery.features.ui.detailedphotos.DetailedPhotosHolder
import com.iyushchuk.flickrgallery.features.ui.detailedphotos.DetailedPhotosHolderFragment
import com.iyushchuk.flickrgallery.features.ui.feed.FeedHolder
import com.iyushchuk.flickrgallery.features.ui.feed.cards.FeedCardsFragment
import com.iyushchuk.flickrgallery.features.ui.feed.grid.FeedGridFragment
import com.iyushchuk.flickrgallery.features.ui.splash.SplashFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class AppScreens {

    class SplashScreen: SupportAppScreen() {
        override fun getFragment(): Fragment {
            return SplashFragment()
        }
    }

    class FeedCardsScreen(private val feedHolder: FeedHolder): SupportAppScreen() {
        override fun getFragment(): Fragment {
            return FeedCardsFragment.newInstance(feedHolder)
        }
    }

    class FeedGridScreen(private val feedHolder: FeedHolder): SupportAppScreen() {
        override fun getFragment(): Fragment {
            return FeedGridFragment.newInstance(feedHolder)
        }
    }


    class DetailedPhotosHolderScreen(private val holder: DetailedPhotosHolder): SupportAppScreen() {
        override fun getFragment(): Fragment {
            return DetailedPhotosHolderFragment.newInstance(holder)
        }
    }
}