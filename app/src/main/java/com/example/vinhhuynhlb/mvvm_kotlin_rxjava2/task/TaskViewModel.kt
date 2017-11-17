package com.example.vinhhuynhlb.mvvm_kotlin_rxjava2.task

import com.example.vinhhuynhlb.basemvvmkotlin.repository.model.User
import com.example.vinhhuynhlb.mvvm_kotlin_rxjava2.data.repository.TaskRepository
import com.example.vinhhuynhlb.mvvm_kotlin_rxjava2.util.SchedulerProvider
import io.reactivex.Observable

/**
 * Copyright © 2017 AsianTech inc.
 * Created by vinh.huynh on 11/16/17.
 */
class TaskViewModel(private val schedulerProvider: SchedulerProvider, private val taskRepository: TaskRepository) {
    fun getUser(): Observable<User> {
        return taskRepository.getUser()
                .observeOn(schedulerProvider.ui())
                .subscribeOn(schedulerProvider.io())
    }
}
