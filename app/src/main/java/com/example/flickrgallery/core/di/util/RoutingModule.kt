package com.example.flickrgallery.core.di.util

import com.example.flickrgallery.core.di.AppScope
import com.example.flickrgallery.core.navigation.AppRouter
import dagger.Module
import dagger.Provides
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder

@Module
class RoutingModule {

    @AppScope
    @Provides
    fun provideCicerone(router: AppRouter) = Cicerone.create(router)

    @AppScope
    @Provides
    fun provideNavigationHolder(cicerone: Cicerone<AppRouter>): NavigatorHolder = cicerone.navigatorHolder

    @AppScope
    @Provides
    fun provideRouter() = AppRouter()
}