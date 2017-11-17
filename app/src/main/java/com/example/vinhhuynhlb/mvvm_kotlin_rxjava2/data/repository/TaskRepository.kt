package com.example.vinhhuynhlb.mvvm_kotlin_rxjava2.data.repository

import com.example.vinhhuynhlb.basemvvmkotlin.repository.api.core.ApiService
import com.example.vinhhuynhlb.basemvvmkotlin.repository.model.User
import io.reactivex.Observable

/**
 * Copyright © 2017 AsianTech inc.
 * Created by vinh.huynh on 11/16/17.
 */
class TaskRepository(private val apiService: ApiService) : TaskDataSource {
    override fun getUser(): Observable<User> {
        return apiService.getUsers()
    }
}