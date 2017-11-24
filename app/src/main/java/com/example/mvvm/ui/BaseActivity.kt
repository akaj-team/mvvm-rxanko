package com.example.mvvm.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import io.reactivex.disposables.CompositeDisposable

abstract class BaseActivity : AppCompatActivity() {
    private val subscription: CompositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        bindViewModel()
    }

    override fun onPause() {
        super.onPause()
        unbindViewModel()
        subscription.clear()
    }


    abstract fun bindViewModel()
    abstract fun unbindViewModel()
}
