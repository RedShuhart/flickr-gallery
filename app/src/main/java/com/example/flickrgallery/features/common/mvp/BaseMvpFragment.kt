package com.example.flickrgallery.features.common.mvp

import com.example.flickrgallery.features.common.BaseActivity


open class BaseMvpFragment: MvpAppCompatFragment(), BaseMvpView {

    fun getActivityComponent() = getBaseActivity().getActivityComponent()

    fun getBaseActivity() = requireActivity() as BaseActivity

}