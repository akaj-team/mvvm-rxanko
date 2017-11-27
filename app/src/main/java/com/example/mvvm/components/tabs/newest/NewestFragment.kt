package com.example.mvvm.components.tabs.newest

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.support.v4.alert

/**
 * Copyright © 2016 AsianTech inc.
 * Created by vinh.huynh on 11/6/17.
 */
class NewestFragment : Fragment() {
    companion object {
        fun newInstance() = NewestFragment()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return NewestFragmentUI().createView(AnkoContext.Companion.create(context, this, false))
    }

    fun onClickMe(string: String) {
        alert("Information", "Hello $string") {
            positiveButton("Yes") { Log.d("VVVVV", "VVVV1") }
            negativeButton("No") { Log.d("VVVVV", "VVVV2") }
        }.show()
    }
}
