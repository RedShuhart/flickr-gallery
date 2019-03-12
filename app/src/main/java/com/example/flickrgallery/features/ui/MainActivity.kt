package com.example.flickrgallery.features.ui

import android.os.Bundle
import com.example.flickrgallery.R
import com.example.flickrgallery.features.common.BaseActivity
import com.example.flickrgallery.features.common.mvp.BaseMvpFragment
import com.example.flickrgallery.core.navigation.AppRouter
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

    private fun getCurrentFragment() =
        supportFragmentManager.findFragmentById(R.id.fragmentContainer) as BaseMvpFragment

}