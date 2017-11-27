package com.example.mvvm.components.tabs.newest

import android.support.v4.content.ContextCompat
import android.view.Gravity
import com.example.mvvm.R
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick

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
            button("Click Me") {
                onClick {
                    owner.onClickMe("Vinh hlb")
                }
            }
        }
    }
}
