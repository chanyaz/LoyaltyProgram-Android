package com.loyalty.core.util.extensions

import com.loyalty.core.exceptions.LoyaltyException
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import timber.log.Timber

fun <T> Observable<T>.observeOnUi(): Observable<T> =
        this.observeOn(AndroidSchedulers.mainThread())

fun <T> Observable<T>.subscribeWithErrorLog(onNext: (T) -> Unit): Disposable =
        this.subscribe(onNext) {
            Timber.e(it)
        }

fun <T> Observable<T>.subscribeOrError(message: String, onNext: (T) -> Unit): Disposable =
        this.subscribe(onNext) {
            Timber.e(message)
            throw LoyaltyException(message)
        }