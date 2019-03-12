package com.example.flickrgallery.core.navigation

import com.example.flickrgallery.core.api.models.FlickrImage
import ru.terrakok.cicerone.Router

class AppRouter: Router() {
    fun openSplashScreen() {
        newRootScreen(AppScreens.SplashScreen())
    }

    fun openFeedCardsScreen() {
        newRootScreen(AppScreens.FeedCardsScreen())
    }

    fun openFeedGridScreen() {
        newRootScreen(AppScreens.FeedGridScreen())
    }

    fun openPhotoScreen(flickrImage: FlickrImage) {
        newRootScreen(AppScreens.PhotoScreen(flickrImage))
    }
}