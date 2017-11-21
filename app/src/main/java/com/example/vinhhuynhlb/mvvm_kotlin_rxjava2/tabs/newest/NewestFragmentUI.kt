package com.example.vinhhuynhlb.mvvm_kotlin_rxjava2.tabs.newest

import android.support.v4.content.ContextCompat
import android.view.Gravity
import com.example.vinhhuynhlb.mvvm_kotlin_rxjava2.R
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.sdk25.coroutines.textChangedListener

/**
 * Copyright © 2016 AsianTech inc.
 * Created by vinh.huynh on 11/6/17.
 */
class NewestFragmentUI : AnkoComponent<NewestFragment> {
    override fun createView(ui: AnkoContext<NewestFragment>) = with(ui) {
        verticalLayout {
            lparams(matchParent, matchParent)
            gravity = Gravity.CENTER
            backgroundColor = ContextCompat.getColor(ctx, R.color.green)
            val editText = editText {
                hint = "Input Name"
                textChangedListener {
                    onTextChanged { charSequence, _, _, _ ->
                    }
                }
            }.lparams(matchParent, dip(50)) {
                margin = dip(10)
            }
            button("Click Me") {
                onClick {
                    toast("Hello ${editText.text}")
                }
            }
        }
    }
}
