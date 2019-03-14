package com.iyushchuk.flickrgallery.core.navigation

import com.iyushchuk.flickrgallery.features.ui.detailedphotos.DetailedPhotosHolder
import com.iyushchuk.flickrgallery.features.ui.feed.FeedHolder
import ru.terrakok.cicerone.Router

class AppRouter: Router() {
    fun openSplashScreen() {
        newRootScreen(AppScreens.SplashScreen())
    }

    fun openFeedCardsScreen(feedHolder: FeedHolder) {
        newRootScreen(AppScreens.FeedCardsScreen(feedHolder))
    }

    fun openFeedGridScreen(feedHolder: FeedHolder) {
        newRootScreen(AppScreens.FeedGridScreen(feedHolder))
    }

    fun openDetailedPhotosHolderScreen(holder: DetailedPhotosHolder) {
        newRootScreen(AppScreens.DetailedPhotosHolderScreen(holder))
    }
}