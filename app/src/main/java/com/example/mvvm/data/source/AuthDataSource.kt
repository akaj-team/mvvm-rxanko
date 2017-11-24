package com.example.mvvm.data.source

import com.example.mvvm.data.model.User
import io.reactivex.Observable

/**
 * Created by tien.hoang on 11/23/17.
 */
interface AuthDataSource {
    fun login(email: String, password: String): Observable<User>
    fun register(email: String, password: String, age: Int): Observable<User>
    fun getUserInfo(userId: String): Observable<User>
}
