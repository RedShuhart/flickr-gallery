package com.iyushchuk.flickrgallery.core.di.util

import com.iyushchuk.flickrgallery.core.di.AppScope
import com.iyushchuk.flickrgallery.core.navigation.AppRouter
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