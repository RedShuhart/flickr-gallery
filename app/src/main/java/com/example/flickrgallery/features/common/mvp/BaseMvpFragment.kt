package com.example.flickrgallery.features.common.mvp

import com.example.flickrgallery.features.common.BaseActivity


open class BaseMvpFragment: MvpAppCompatFragment(), BaseMvpView {

    protected fun getActivityComponent() = getBaseActivity().getActivityComponent()

    protected fun getBaseActivity() = requireActivity() as BaseActivity

    open fun onBackPressed(): Boolean {
        return false
    }

}