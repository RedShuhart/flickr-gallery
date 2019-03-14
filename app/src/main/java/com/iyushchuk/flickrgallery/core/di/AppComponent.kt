package com.iyushchuk.flickrgallery.core.di

import com.iyushchuk.flickrgallery.core.di.util.ApiModule
import com.iyushchuk.flickrgallery.core.di.util.AppContextModule
import com.iyushchuk.flickrgallery.core.di.util.RoutingModule
import com.iyushchuk.flickrgallery.core.di.util.SchedulersModule
import com.iyushchuk.flickrgallery.core.di.ui.ActivityComponent
import com.iyushchuk.flickrgallery.core.di.ui.ActivityModule
import dagger.Component

@AppScope
@Component(modules = [ApiModule::class, RoutingModule::class, AppContextModule::class, SchedulersModule::class])
interface AppComponent {

    operator fun plus(activityModule: ActivityModule): ActivityComponent
}
