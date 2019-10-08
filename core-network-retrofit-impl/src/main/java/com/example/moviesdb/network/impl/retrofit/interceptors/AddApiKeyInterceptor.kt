package com.example.moviesdb.network.impl.retrofit.interceptors

import com.example.moviesdb.network.model.API_KEY
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AddApiKeyInterceptor @Inject constructor() : Interceptor {

    private companion object {
        const val API_KEY_QUERY = "api_key"
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val originalHttpUrl = originalRequest.url()

        val url = originalHttpUrl.newBuilder()
            .addQueryParameter(API_KEY_QUERY, API_KEY)
            .build()
        val requestBuilder = originalRequest.newBuilder()
            .url(url)
        return chain.proceed(requestBuilder.build())
    }

}