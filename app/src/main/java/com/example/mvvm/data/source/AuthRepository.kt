package com.example.mvvm.data.source

import com.example.mvvm.data.model.User
import com.example.mvvm.data.source.remote.AuthRemoteDataSource
import io.reactivex.Observable

/**
 * Created by tien.hoang on 11/23/17.
 */
class AuthRepository : AuthDataSource {
    private val remoteDataSource = AuthRemoteDataSource()
    override fun getUserInfo(userId: String): Observable<User> {
        return remoteDataSource.getUserInfo(userId)
    }

    override fun login(email: String, password: String): Observable<User> {
        return remoteDataSource.login(email, password)
    }

    override fun register(email: String, password: String, age: Int): Observable<User> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}