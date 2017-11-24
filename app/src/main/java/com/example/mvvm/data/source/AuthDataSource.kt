package com.example.mvvm.data.source

import com.example.mvvm.data.api.response.LoginResponse
import com.example.mvvm.data.api.response.RegisterResponse
import io.reactivex.Observable

/**
 * Created by tien.hoang on 11/23/17.
 */
interface AuthDataSource {
    fun login(email: String, password: String): Observable<LoginResponse>
    fun register(email: String, password: String, age: Int): Observable<RegisterResponse>
}
