package com.example.moviesdb.network.impl.retrofit.interceptors

import okhttp3.Interceptor
import okhttp3.Response
import java.util.*
import javax.inject.Inject

class AddCountryAndLanguageInterceptor @Inject constructor() : Interceptor {

    private companion object {
        const val LANGUAGE_QUERY = "language"
        const val REGION_QUERY = "region"
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val originalHttpUrl = originalRequest.url

        val locale = Locale.getDefault()
        val url = originalHttpUrl.newBuilder()
            .addQueryParameter(LANGUAGE_QUERY, locale.language)
            .addQueryParameter(REGION_QUERY, locale.country)
            .build()
        val requestBuilder = originalRequest.newBuilder()
            .url(url)
        return chain.proceed(requestBuilder.build())
    }

}