package com.example.vinhhuynhlb.mvvm_kotlin_rxjava2.util

import com.example.vinhhuynhlb.mvvm_kotlin_rxjava2.BaseSchedulerProvider
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Copyright © 2017 AsianTech inc.
 * Created by vinh.huynh on 11/16/17.
 */
class SchedulerProvider : BaseSchedulerProvider {
    companion object {
        private var sSchedulerProvider: SchedulerProvider? = null

        fun getInstance(): SchedulerProvider {
            if (sSchedulerProvider == null) {
                sSchedulerProvider = SchedulerProvider()
            }
            return sSchedulerProvider!!
        }
    }

    override fun io(): Scheduler = Schedulers.io()

    override fun ui(): Scheduler = AndroidSchedulers.mainThread()

    override fun computation(): Scheduler = Schedulers.computation()
}
