package com.example.mvvm.data.source.remote.core

import com.example.mvvm.BuildConfig
import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Remote api
 */
object ApiClient {

    private val TIMEOUT = 20_000L
    private val HEADER_AUTH_KEY = "Authorization"
    private val HEADER_AUTH_PREFIX = "token"

    var token: String = "85ef710c8c8e218aebb081"
        get() {
            return "$HEADER_AUTH_PREFIX $field"
        }
    val instance: ApiService by lazy {
        val httpClient = OkHttpClient.Builder()

        httpClient.addInterceptor { chain ->
            val request = chain.request().newBuilder()
            request.addHeader(HEADER_AUTH_KEY, token)
            chain.proceed(request.build())
        }
        if (BuildConfig.DEBUG) {
            httpClient.addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        }

        httpClient.readTimeout(TIMEOUT, TimeUnit.MILLISECONDS)
        httpClient.writeTimeout(TIMEOUT, TimeUnit.MILLISECONDS)
        httpClient.connectTimeout(TIMEOUT, TimeUnit.SECONDS)
        val retrofit = Retrofit.Builder()
                .baseUrl("https://freestory.000webhostapp.com/api/")
                .addCallAdapterFactory(CustomCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder()
                        .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                        .create()))
                .client(httpClient.build())
                .build()

        retrofit.create(ApiService::class.java)
    }
}