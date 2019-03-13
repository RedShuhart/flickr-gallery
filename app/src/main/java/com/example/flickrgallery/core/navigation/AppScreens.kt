package com.example.flickrgallery.core.navigation

import androidx.fragment.app.Fragment
import com.example.flickrgallery.features.ui.detailedphotos.DetailedPhotosHolder
import com.example.flickrgallery.features.ui.detailedphotos.DetailedPhotosHolderFragment
import com.example.flickrgallery.features.ui.feed.cards.FeedCardsFragment
import com.example.flickrgallery.features.ui.feed.grid.FeedGridFragment
import com.example.flickrgallery.features.ui.splash.SplashFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class AppScreens {

    class SplashScreen: SupportAppScreen() {
        override fun getFragment(): Fragment {
            return SplashFragment()
        }
    }

    class FeedCardsScreen: SupportAppScreen() {
        override fun getFragment(): Fragment {
            return FeedCardsFragment.newInstance()
        }
    }

    class FeedGridScreen: SupportAppScreen() {
        override fun getFragment(): Fragment {
            return FeedGridFragment.newInstance()
        }
    }


    class DetailedPhotosHolderScreen(private val holder: DetailedPhotosHolder): SupportAppScreen() {
        override fun getFragment(): Fragment {
            return DetailedPhotosHolderFragment.newInstance(holder)
        }
    }
}