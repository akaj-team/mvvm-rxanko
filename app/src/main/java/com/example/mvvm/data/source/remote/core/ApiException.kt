package com.example.mvvm.data.source.remote.core

class ApiException(message: String?) : Throwable(message) {
    lateinit var errorCode: String
    lateinit var errorMessage: String
}
