package com.example.flickrgallery.di.ui

import com.example.flickrgallery.di.AppScope
import com.example.flickrgallery.di.ui.fragments.FragmentComponent
import com.example.flickrgallery.di.ui.fragments.FragmentModule
import com.example.flickrgallery.features.common.BaseActivity
import com.example.flickrgallery.features.ui.MainActivity
import com.example.flickrgallery.features.ui.MainActivity_MembersInjector
import dagger.Subcomponent

@UIScope
@Subcomponent(modules = [ActivityModule::class])
interface ActivityComponent {

    operator fun plus(module: FragmentModule): FragmentComponent

    fun inject(baseActivity: BaseActivity)
    fun inject(mainActivity: MainActivity)
}