package com.example.flickrgallery.features.ui

import android.os.Bundle
import com.example.flickrgallery.R
import com.example.flickrgallery.features.common.BaseActivity
import com.example.flickrgallery.features.common.mvp.BaseMvpFragment
import com.example.flickrgallery.navigation.AppRouter
import javax.inject.Inject

class MainActivity: BaseActivity() {

    @Inject
    lateinit var router: AppRouter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        getActivityComponent().inject(this)
        setContentView(R.layout.base_activity)
        if (savedInstanceState == null) {
            // TODO: NAVIGATE TO SPLASH SCREEN
        }
    }

    private fun getCurrenFragment() =
        supportFragmentManager.findFragmentById(R.id.fragmentContainer) as BaseMvpFragment
}