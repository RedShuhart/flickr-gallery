package com.example.flickrgallery.di.core

import com.example.flickrgallery.di.AppScope
import com.example.flickrgallery.navigation.AppRouter
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