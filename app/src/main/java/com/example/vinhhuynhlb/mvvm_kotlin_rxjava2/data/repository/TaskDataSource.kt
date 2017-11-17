package com.example.vinhhuynhlb.mvvm_kotlin_rxjava2.data.repository

import com.example.vinhhuynhlb.basemvvmkotlin.repository.model.User
import io.reactivex.Observable

/**
 * Copyright © 2017 AsianTech inc.
 * Created by vinh.huynh on 11/16/17.
 */
interface TaskDataSource {
    fun getUser(): Observable<User>
}
