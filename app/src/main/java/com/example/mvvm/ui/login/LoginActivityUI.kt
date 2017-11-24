package com.example.mvvm.ui.login

import android.widget.Button
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick


class LoginActivityUI : AnkoComponent<LoginActivity> {

    internal lateinit var btnLogin: Button

    override fun createView(ui: AnkoContext<LoginActivity>) = with(ui) {
        verticalLayout {
            lparams(matchParent, matchParent)
            val edtEmail = editText {
                hint = "Email"
            }.lparams(matchParent, wrapContent) {
            }
            val edtPassword = editText {
                hint = "Password"
            }.lparams(matchParent, wrapContent)
            btnLogin = button {
                text = "Login"
                onClick {
                    owner.callLogin(edtEmail.text.toString(), edtPassword.text.toString())
                }
            }.lparams(matchParent, wrapContent)
        }
    }
}