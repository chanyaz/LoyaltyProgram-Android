package com.loyalty.customer.network.interceptors

import com.loyalty.customer.preferences.token.TokenPreferences
import okhttp3.Interceptor
import okhttp3.Response

class TokenInterceptor(
        tokenPreferences: TokenPreferences
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        /* todo add implementation */
        return chain.proceed(chain.request())
    }

}