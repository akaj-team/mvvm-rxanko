package com.example.vinhhuynhlb.basemvvmkotlin.repository.api.core

import com.example.vinhhuynhlb.mvvm_kotlin_rxjava2.BuildConfig
import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Copyright © 2016 AsianTech inc.
 * Created by vinh.huynh on 10/16/17.
 */
object ApiClient {
    private val CONNECTION_TIMEOUT = TimeUnit.MINUTES.toMillis(3)
    private val mApiService: ApiService

    fun getApiService(): ApiService = mApiService

    init {
        val builder = OkHttpClient.Builder()
        builder.addInterceptor({ chain ->
            val accessToken = "2ad7ced7d139e4806185ef710c8c8e218aebb081"
            val original = chain.request()
            val request = original.newBuilder()
                    .addHeader("Authorization",
                            "token " + accessToken)
                    .build()

            chain.proceed(request)
        })
        //Enable log debug for debug mode
        if (BuildConfig.DEBUG) {
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY
            builder.addInterceptor(logging)
        }

        builder.connectTimeout(CONNECTION_TIMEOUT, TimeUnit.MILLISECONDS)
        builder.readTimeout(CONNECTION_TIMEOUT, TimeUnit.MILLISECONDS)
        builder.writeTimeout(CONNECTION_TIMEOUT, TimeUnit.MILLISECONDS)
        val okHttpClient = builder.build()
        val gSon = GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create()

        val retrofit = Retrofit.Builder()
                .baseUrl("https://freestory.000webhostapp.com/api/")
                .addConverterFactory(GsonConverterFactory.create(gSon))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build()
        mApiService = retrofit.create(ApiService::class.java)
    }
}