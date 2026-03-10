package com.works.utils

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

    object Client {

        private const val BASE_URL = "https://jsonbulut.com/api/"

        private val client = OkHttpClient.Builder().build()

        val retrofit: Retrofit by lazy {

            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }

