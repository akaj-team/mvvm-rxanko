package com.example.vinhhuynhlb.mvvm_kotlin_rxjava2.tabs

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import org.jetbrains.anko.setContentView

/**
 * Copyright © 2016 AsianTech inc.
 * Created by vinh.huynh on 11/2/17.
 */
class TabActivity : AppCompatActivity() {
    lateinit var tabLayout: TabLayout
    lateinit var viewPager: ViewPager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        TabActivityUI(TabAdapter(supportFragmentManager)).setContentView(this)
        tabLayout.setupWithViewPager(viewPager)
    }
}
