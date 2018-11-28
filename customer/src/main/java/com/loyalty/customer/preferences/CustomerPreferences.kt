package com.loyalty.customer.preferences

import io.reactivex.Completable
import io.reactivex.Single

interface CustomerPreferences {

    fun saveCustomerToken(token: String): Completable

    fun getCustomerToken(): Single<String>

    fun isUserLoggedIn(): Single<Boolean>

}