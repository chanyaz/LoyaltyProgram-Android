package com.loyalty.core.util.extensions

import com.loyalty.core.exceptions.LoyaltyException
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import timber.log.Timber

fun <T> Single<T>.observeOnUi(): Single<T> =
        this.observeOn(AndroidSchedulers.mainThread())

fun <T> Single<T>.subscribeWithErrorLog(onSuccess: (T) -> Unit): Disposable =
        this.subscribe(onSuccess) { Timber.e(it) }

fun <T> Single<T>.subscribeOrError(message: String, onSuccess: (T) -> Unit): Disposable =
        this.subscribe(onSuccess) {
            Timber.e(message)
            throw LoyaltyException(message)
        }