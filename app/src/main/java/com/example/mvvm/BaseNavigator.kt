package com.example.mvvm

/**
 * Copyright © 2017 AsianTech inc.
 * Created by vinh.huynh on 11/16/17.
 */
interface BaseNavigator {
    fun finishActivity()

    fun finishAcitivityWithResult(result: Int)

    fun startActivityForResult(vararg params: Pair<String, Any?>, resultCode: Int)

    fun startActivityForResultWithExtra(vararg params: Pair<String, Any?>, resultCode: Int,
                                        extraKey: String, extraValue: Any)

    fun startActivity(vararg params: Pair<String, Any?>)
}
