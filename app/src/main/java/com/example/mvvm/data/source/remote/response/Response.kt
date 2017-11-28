package com.example.mvvm.data.source.remote.response

/**
 * Created by tien.hoang on 11/24/17.
 */
class Response<T> {
    var statusCode = 0
    val message: String = ""
    var data: T? = null
}