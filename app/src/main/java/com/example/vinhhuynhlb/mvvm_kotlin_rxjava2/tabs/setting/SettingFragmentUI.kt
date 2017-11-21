package com.example.vinhhuynhlb.lifecompanion.ui.tabs.setting

import android.view.Gravity
import com.example.vinhhuynhlb.mvvm_kotlin_rxjava2.tabs.setting.SettingFragment
import org.jetbrains.anko.*

/**
 * Copyright © 2016 AsianTech inc.
 * Created by vinh.huynh on 11/6/17.
 */
open class SettingFragmentUI : AnkoComponent<SettingFragment> {
    override fun createView(ui: AnkoContext<SettingFragment>) = with(ui) {
        verticalLayout {
            lparams(matchParent, matchParent)
            gravity = Gravity.CENTER
            textView {
                text = "SettingFragmentUI"
            }.lparams(wrapContent, wrapContent)
        }
    }
}