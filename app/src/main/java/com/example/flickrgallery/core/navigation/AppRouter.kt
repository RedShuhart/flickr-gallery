package com.example.flickrgallery.core.navigation

import ru.terrakok.cicerone.Router

class AppRouter: Router() {
    fun openSplashScreen() {
        newRootScreen(AppScreens.SplashScreen())
    }

    fun openFeedScreen() {
        newRootScreen(AppScreens.FeedScreen())
    }
}