package com.example.flickrgallery.core.di

import com.example.flickrgallery.core.di.util.ApiModule
import com.example.flickrgallery.core.di.util.AppContextModule
import com.example.flickrgallery.core.di.util.RoutingModule
import com.example.flickrgallery.core.di.util.SchedulersModule
import com.example.flickrgallery.core.di.ui.ActivityComponent
import com.example.flickrgallery.core.di.ui.ActivityModule
import dagger.Component

@AppScope
@Component(modules = [ApiModule::class, RoutingModule::class, AppContextModule::class, SchedulersModule::class])
interface AppComponent {

    operator fun plus(activityModule: ActivityModule): ActivityComponent
}
