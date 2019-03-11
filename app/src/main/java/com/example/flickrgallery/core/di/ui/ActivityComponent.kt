package com.example.flickrgallery.core.di.ui

import com.example.flickrgallery.core.di.ui.fragments.FragmentComponent
import com.example.flickrgallery.core.di.ui.fragments.FragmentModule
import com.example.flickrgallery.features.common.BaseActivity
import com.example.flickrgallery.features.ui.MainActivity
import dagger.Subcomponent

@UIScope
@Subcomponent(modules = [ActivityModule::class])
interface ActivityComponent {

    operator fun plus(module: FragmentModule): FragmentComponent

    fun inject(baseActivity: BaseActivity)
    fun inject(mainActivity: MainActivity)
}