package com.example.flickrgallery.core.navigation

import com.example.flickrgallery.core.api.models.FlickrImage
import com.example.flickrgallery.features.ui.detailedphotos.DetailedPhotosHolder
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

    fun openDetailedPhotosHolderScreen(holder: DetailedPhotosHolder) {
        newRootScreen(AppScreens.DetailedPhotosHolderScreen(holder))
    }
}