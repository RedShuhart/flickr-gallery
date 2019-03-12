package com.example.flickrgallery.core.navigation

import androidx.fragment.app.Fragment
import com.example.flickrgallery.core.api.models.FlickrImage
import com.example.flickrgallery.features.ui.feed.FeedFragment
import com.example.flickrgallery.features.ui.photo.PhotoFragment
import com.example.flickrgallery.features.ui.splash.SplashFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class AppScreens {

    class SplashScreen: SupportAppScreen() {
        override fun getFragment(): Fragment {
            return SplashFragment()
        }
    }

    class FeedScreen: SupportAppScreen() {
        override fun getFragment(): Fragment {
            return FeedFragment.newInstance()
        }
    }
    class PhotoScreen(private val flickrImage: FlickrImage): SupportAppScreen() {
        override fun getFragment(): Fragment {
            return PhotoFragment.newInstance(flickrImage)
        }
    }
}