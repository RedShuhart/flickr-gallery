package com.example.flickrgallery.core.schedulers

import io.reactivex.ObservableTransformer
import io.reactivex.Scheduler

abstract class RxSchedulers {

    abstract fun mainThread(): Scheduler

    abstract fun io(): Scheduler

    fun <T> ioToMain(): ObservableTransformer<T, T> {
        return ObservableTransformer { objectObservable ->
            objectObservable
                .subscribeOn(io())
                .observeOn(mainThread())
        }
    }
}