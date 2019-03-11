package com.example.flickrgallery.di.ui

import com.example.flickrgallery.di.AppScope
import com.example.flickrgallery.features.common.BaseActivity
import dagger.Subcomponent

@AppScope
@Subcomponent(modules = [ActivityModule::class])
interface ActivityComponent {

    fun inject(baseActivity: BaseActivity)
}