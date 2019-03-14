package com.iyushchuk.flickrgallery.features.ui

import android.os.Bundle
import com.iyushchuk.flickrgallery.R
import com.iyushchuk.flickrgallery.features.common.BaseActivity
import com.iyushchuk.flickrgallery.features.common.mvp.BaseMvpFragment
import com.iyushchuk.flickrgallery.core.navigation.AppRouter
import javax.inject.Inject

class MainActivity: BaseActivity() {

    @Inject
    lateinit var router: AppRouter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        getActivityComponent().inject(this)
        setContentView(R.layout.base_activity)
        if (savedInstanceState == null) {
            router.openSplashScreen()
        }
    }

    override fun onBackPressed() {
        val currentMvpFragment = getCurrentFragment()
        if (currentMvpFragment.onBackPressed()) {
            return
        }

        super.onBackPressed()
    }

    private fun getCurrentFragment() =
        supportFragmentManager.findFragmentById(R.id.fragmentContainer) as BaseMvpFragment

}