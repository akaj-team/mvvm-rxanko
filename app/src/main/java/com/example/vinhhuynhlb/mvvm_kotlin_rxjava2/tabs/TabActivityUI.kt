package com.example.vinhhuynhlb.mvvm_kotlin_rxjava2.tabs

import android.support.v4.content.ContextCompat
import com.example.vinhhuynhlb.mvvm_kotlin_rxjava2.R
import org.jetbrains.anko.*
import org.jetbrains.anko.design.tabLayout
import org.jetbrains.anko.support.v4.viewPager

/**
 * Copyright © 2016 AsianTech inc.
 * Created by vinh.huynh on 11/2/17.
 */
class TabActivityUI(private val tabAdapter: TabAdapter) : AnkoComponent<TabActivity> {
    companion object {
        private const val ID_TAB_LAYOUT = 9292
        private const val ID_VIEWPAGER = 9293
    }

    override fun createView(ui: AnkoContext<TabActivity>) = with(ui) {
        relativeLayout {
            lparams(matchParent, matchParent)
            owner.tabLayout = tabLayout {
                id = ID_TAB_LAYOUT
                backgroundColor = ContextCompat.getColor(ctx, R.color.green)
            }.lparams(matchParent, dip(50)) {
                alignParentBottom()
            }
            owner.viewPager = viewPager {
                id = ID_VIEWPAGER
                adapter = tabAdapter
            }.lparams(matchParent, matchParent) {
                above(ID_TAB_LAYOUT)
            }
        }
    }
}
