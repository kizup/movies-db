package com.example.moviesdb.di

import dagger.Component

@Component(
    modules = [RetrofitNetworkModule::class]
)
interface RetrofitNetworkComponent {
}