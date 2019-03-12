package com.example.flickrgallery.core.schedulers

import io.reactivex.ObservableTransformer
import io.reactivex.Scheduler
import io.reactivex.SingleTransformer

abstract class RxSchedulers {

    abstract fun mainThread(): Scheduler

    abstract fun io(): Scheduler

    abstract fun computation(): Scheduler

    fun <T> ioToMain(): ObservableTransformer<T, T> {
        return ObservableTransformer { objectObservable ->
            objectObservable
                .subscribeOn(io())
                .observeOn(mainThread())
        }
    }

    fun <T> computationToMainSingle(): SingleTransformer<T, T> {
        return SingleTransformer { objectObservable ->
            objectObservable
                .subscribeOn(computation())
                .observeOn(mainThread())
        }
    }
}