package com.example.mvvm.ui.login

import android.os.Bundle
import com.example.mvvm.data.model.User
import com.example.mvvm.data.source.AuthRepository
import com.example.mvvm.data.source.remote.core.CallbackWrapper
import com.example.mvvm.ui.BaseActivity
import com.example.mvvm_kotlin_rxjava2.util.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import org.jetbrains.anko.setContentView

/**
 * A login screen that offers login via email/password.
 */
class LoginActivity : BaseActivity() {
    private lateinit var viewModel: LoginViewModel
    private val subscription: CompositeDisposable = CompositeDisposable()
    private lateinit var ui: LoginActivityUI
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ui = LoginActivityUI()
        ui.setContentView(this)
    }

    internal fun callLogin(email: String, password: String) {
        subscription.add(viewModel.login(email, password)
                .subscribeWith(object : CallbackWrapper<User>(this) {
                    override fun onSuccess(t: User) {

                    }
                }))
    }

    override fun bindViewModel() {
        viewModel = LoginViewModel(SchedulerProvider.getInstance(), AuthRepository())
    }


    override fun unbindViewModel() {

    }
}
