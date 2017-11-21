package com.example.vinhhuynhlb.mvvm_kotlin_rxjava2.tabs.setting

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.vinhhuynhlb.lifecompanion.ui.tabs.setting.SettingFragmentUI
import org.jetbrains.anko.AnkoContext

/**
 * Copyright © 2016 AsianTech inc.
 * Created by vinh.huynh on 11/6/17.
 */
class SettingFragment : Fragment() {
    companion object {
        fun newInstance() = SettingFragment()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return SettingFragmentUI().createView(AnkoContext.Companion.create(context, this, false))
    }
}
