package com.loyalty.core.preferences

import android.content.Context
import com.loyalty.core.extensions.editAndApply
import io.reactivex.Completable
import io.reactivex.Single

abstract class RxPreferences(context: Context, preferencesName: String) {

    private val preferences = context.getSharedPreferences(preferencesName, Context.MODE_PRIVATE)

    protected fun getString(key: String): Single<String> {
        return Single.just(preferences.getString(key, ""))
    }

    protected fun saveString(key: String, value: String): Completable {
        return Completable.fromCallable {
            preferences.editAndApply {
                putString(key, value)
            }
        }
    }

    protected fun getBoolean(key: String): Single<Boolean> {
        return Single.just(preferences.getBoolean(key, true))
    }

    protected fun saveBoolean(key: String, value: Boolean): Completable {
        return Completable.fromCallable {
            preferences.editAndApply {
                putBoolean(key, value)
            }
        }
    }

    protected fun getInt(key: String): Single<Int> {
        return Single.just(preferences.getInt(key, 0))
    }

    protected fun saveInt(key: String, value: Int): Completable {
        return Completable.fromCallable {
            preferences.editAndApply {
                putInt(key, value)
            }
        }
    }

    protected fun getFloat(key: String): Single<Float> {
        return Single.just(preferences.getFloat(key, 0.0f))
    }

    protected fun saveFloat(key: String, value: Float): Completable {
        return Completable.fromCallable {
            preferences.editAndApply {
                putFloat(key, value)
            }
        }
    }

    protected fun getLong(key: String): Single<Long> {
        return Single.just(preferences.getLong(key, 0L))
    }

    protected fun saveLong(key: String, value: Long): Completable {
        return Completable.fromCallable {
            preferences.editAndApply {
                putLong(key, value)
            }
        }
    }

}