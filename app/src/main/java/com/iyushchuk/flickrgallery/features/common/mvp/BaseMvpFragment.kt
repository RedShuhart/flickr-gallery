package com.iyushchuk.flickrgallery.features.common.mvp

import com.iyushchuk.flickrgallery.features.common.BaseActivity


open class BaseMvpFragment: MvpAppCompatFragment(), BaseMvpView {

    protected fun getActivityComponent() = getBaseActivity().getActivityComponent()

    protected fun getBaseActivity() = requireActivity() as BaseActivity

    open fun onBackPressed(): Boolean {
        return false
    }

}