package com.iyushchuk.flickrgallery.features.common

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.iyushchuk.flickrgallery.FlickrApp
import com.iyushchuk.flickrgallery.R
import com.iyushchuk.flickrgallery.core.di.ui.ActivityComponent
import com.iyushchuk.flickrgallery.core.di.ui.ActivityModule
import com.iyushchuk.flickrgallery.core.navigation.AppNavigator

import ru.terrakok.cicerone.NavigatorHolder
import javax.inject.Inject

open class BaseActivity : AppCompatActivity() {

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    private val navigator: AppNavigator = AppNavigator(this, R.id.fragmentContainer)

    private var activityComponent: ActivityComponent? = null

    fun getActivityComponent() =
        activityComponent ?: createComponent()
            .also { activityComponent = it }

    private fun createComponent() = (application as FlickrApp).appComponent.plus(ActivityModule(this))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        getActivityComponent().inject(this)
    }

    override fun onResume() {
        super.onResume()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        navigatorHolder.removeNavigator()
    }
}