package com.example.vinhhuynhlb.mvvm_kotlin_rxjava2

import io.reactivex.Scheduler

/**
 * Copyright © 2017 AsianTech inc.
 * Created by vinh.huynh on 11/16/17.
 */
interface BaseSchedulerProvider {
    fun computation(): Scheduler

    fun io(): Scheduler

    fun ui(): Scheduler
}
