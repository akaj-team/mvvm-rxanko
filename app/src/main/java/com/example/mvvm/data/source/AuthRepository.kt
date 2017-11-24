package com.example.mvvm.data.source

import android.util.Log
import com.example.mvvm.data.api.core.ApiClient
import com.example.mvvm.data.api.response.LoginResponse
import com.example.mvvm.data.api.response.RegisterResponse
import io.reactivex.Observable

/**
 * Created by tien.hoang on 11/23/17.
 */
class AuthRepository : AuthDataSource {
    override fun login(email: String, password: String): Observable<LoginResponse> {
        Log.d("xxx", "login called")
        return ApiClient.getApiService().login(email)
    }

    override fun register(email: String, password: String, age: Int): Observable<RegisterResponse> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}