package com.example.flickrgallery.features.ui.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.flickrgallery.R
import com.example.flickrgallery.core.di.ui.fragments.SplashModule
import com.example.flickrgallery.features.common.mvp.BaseMvpFragment
import javax.inject.Inject

class SplashFragment : BaseMvpFragment(), SplashView {

    @Inject
    @InjectPresenter
    lateinit var splashPresenter: SplashPresenter

    @ProvidePresenter
    fun providePresenter(): SplashPresenter {
        return splashPresenter
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        getActivityComponent().plus(SplashModule()).inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.splash_fragment, container, false)
    }
}