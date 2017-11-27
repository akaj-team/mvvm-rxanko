package com.example.mvvm.ui.login

import com.example.mvvm.data.model.User
import com.example.mvvm.data.source.AuthRepository
import com.example.mvvm_kotlin_rxjava2.util.SchedulerProvider
import io.reactivex.Observable

/**
 * Created by tien.hoang on 11/23/17.
 */
class LoginViewModel(private val schedulerProvider: SchedulerProvider,
                     private val authRepository: AuthRepository) {

    fun login(email: String, password: String): Observable<User> {
        return authRepository.login(email, password)
                .observeOn(schedulerProvider.ui())
                .subscribeOn(schedulerProvider.io())
                .doOnSubscribe {
                    // Show dialog loading
                }.doOnComplete {
            // Hide dialog loading
        }
    }


}