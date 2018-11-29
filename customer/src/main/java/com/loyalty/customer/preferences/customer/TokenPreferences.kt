package com.loyalty.customer.preferences.customer

import io.reactivex.Completable
import io.reactivex.Single

interface TokenPreferences {

    fun saveCustomerToken(token: String): Completable

    fun getCustomerToken(): Single<String>

    fun isUserLoggedIn(): Single<Boolean>

}