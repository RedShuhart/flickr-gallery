package com.example.flickrgallery.di.ui

import androidx.fragment.app.FragmentActivity
import com.example.flickrgallery.di.AppScope
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(private val activity: FragmentActivity) {

    @UIScope
    @Provides
    fun provideActivity() = activity
}
