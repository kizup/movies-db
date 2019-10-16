package com.example.moviesdb.movies.list.di

import com.example.moviesdb.network.api.TheMovieDBClientApi
import com.example.moviesdb.network.impl.retrofit.IApiService
import com.example.moviesdb.network.impl.retrofit.TheMovieDBClientApiImpl
import com.example.moviesdb.network.impl.retrofit.interceptors.AddApiKeyInterceptor
import com.example.moviesdb.network.model.BASE_API_URL
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class RetrofitNetworkModule {

    @Provides
    @Singleton
    fun provideTheMovieDbApiClient(apiService: IApiService): TheMovieDBClientApi {
        return TheMovieDBClientApiImpl(apiService)
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): IApiService {
        return retrofit.create(IApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideRetrofit(gson: Gson, okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BASE_API_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    @Provides
    @Singleton
    fun provideGson(): Gson {
        return GsonBuilder()
            .setPrettyPrinting()
            .create()
    }

    @Provides
    @Singleton
    fun provideHttpClient(
        apiKeyInterceptor: AddApiKeyInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder().let { builder ->
            builder.addInterceptor(apiKeyInterceptor)
            return@let builder.build()
        }
    }

}