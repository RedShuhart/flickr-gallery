package com.example.flickrgallery.features.common.mvp

import com.arellomobile.mvp.MvpPresenter
import com.arellomobile.mvp.MvpView
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

open class BaseMvpPresenter<View: MvpView>: MvpPresenter<View>() {
    private val disposables = CompositeDisposable()

    fun Disposable.unsubscribeOnDestroy(): Disposable {
        disposables.add(this)
        return this
    }

    override fun onDestroy() {
        disposables.dispose()
        super.onDestroy()
    }
}
