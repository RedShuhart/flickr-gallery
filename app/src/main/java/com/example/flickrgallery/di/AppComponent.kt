package com.example.flickrgallery.di

import com.example.flickrgallery.di.core.ApiModule
import com.example.flickrgallery.di.core.AppContextModule
import com.example.flickrgallery.di.core.RoutingModule
import com.example.flickrgallery.di.core.SchedulersModule
import com.example.flickrgallery.di.ui.ActivityComponent
import com.example.flickrgallery.di.ui.ActivityModule
import dagger.Component

@AppScope
@Component(modules = [ApiModule::class, RoutingModule::class, AppContextModule::class, SchedulersModule::class])
interface AppComponent {

    operator fun plus(activityModule: ActivityModule): ActivityComponent
}
