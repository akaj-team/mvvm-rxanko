package com.example.mvvm.data.source.remote

import com.example.mvvm.data.model.User
import com.example.mvvm.data.source.remote.core.ApiClient
import com.example.mvvm.data.source.AuthDataSource
import io.reactivex.Observable

/**
 * Created by tien.hoang on 11/23/17.
 */
class AuthRemoteDataSource : AuthDataSource {
    override fun getUserInfo(userId: String): Observable<User> {
        return ApiClient.instance.getUserInfo().map { it.data }
    }

    override fun login(email: String, password: String): Observable<User> {
        return ApiClient.instance.login(email).map { it.data }
    }

    override fun register(email: String, password: String, age: Int): Observable<User> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}