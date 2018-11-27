package com.loyalty.customer.network.interceptors

import com.loyalty.customer.preferences.CustomerPreferences
import okhttp3.Interceptor
import okhttp3.Response

class TokenInterceptor(
        customerPreferences: CustomerPreferences
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        /* todo add implementation */
        return chain.proceed(chain.request())
    }

}