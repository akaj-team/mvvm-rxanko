package com.example.mvvm.components.tabs

import android.support.design.widget.NavigationView
import android.support.v4.content.ContextCompat
import android.support.v4.view.GravityCompat
import android.support.v4.view.ViewPager
import android.support.v4.widget.DrawerLayout
import android.view.Gravity
import com.example.mvvm.R
import com.example.mvvm.components.view.HeaderBarView
import com.example.mvvm.components.view.OnHeaderBarListener
import com.example.mvvm.components.view.headerBar
import org.jetbrains.anko.*
import org.jetbrains.anko.design.navigationView
import org.jetbrains.anko.design.tabLayout
import org.jetbrains.anko.support.v4.drawerLayout
import org.jetbrains.anko.support.v4.onPageChangeListener
import org.jetbrains.anko.support.v4.viewPager

/**
 * Copyright © 2016 AsianTech inc.
 * Created by vinh.huynh on 11/2/17.
 */
class TabActivityUI(private val tabAdapter: TabAdapter) : AnkoComponent<TabActivity> {
    companion object {
        private const val ID_TAB_LAYOUT = 9292
        private const val ID_VIEWPAGER = 9293
        private const val ID_HEADER_BAR = 9293
    }

    lateinit var drawer: DrawerLayout
    lateinit var navigation: NavigationView
    lateinit var toolbar: HeaderBarView
    lateinit var viewpager: ViewPager
    override fun createView(ui: AnkoContext<TabActivity>) = with(ui) {
        relativeLayout {
            lparams(matchParent, matchParent)
            drawer = drawerLayout {
                relativeLayout {
                    lparams(matchParent, matchParent)
                    viewpager = viewPager {
                        id = ID_VIEWPAGER
                        adapter = tabAdapter
                        onPageChangeListener {
                            onPageSelected { position ->
                                toolbar.setToolBarTitle(tabAdapter.getPageTitle(position).toString())
                            }
                        }
                    }.lparams(matchParent, matchParent) {
                        above(ID_TAB_LAYOUT)
                    }
                    tabLayout {
                        setupWithViewPager(viewpager)
                        id = ID_TAB_LAYOUT
                        backgroundColor = ContextCompat.getColor(ctx, R.color.green)
                    }.lparams(matchParent, dip(50)) {
                        alignParentBottom()
                    }
                }
                navigation = navigationView {
                    inflateMenu(R.menu.menu_drawer_main)
                }.lparams(wrapContent, matchParent) {
                    gravity = Gravity.START
                }
            }.lparams(matchParent, matchParent) {
                below(ID_HEADER_BAR)
            }

            toolbar = headerBar(object : OnHeaderBarListener {
                override fun onLeftMenuClick() {
                    if (drawer.isDrawerOpen(GravityCompat.START)) {
                        drawer.closeDrawers()
                    } else {
                        drawer.openDrawer(GravityCompat.START)
                    }
                }
            }, ID_HEADER_BAR)
                    .setToolBarTitle(tabAdapter.getPageTitle(0).toString())
                    .lparams(matchParent, dip(48)) {
                        alignParentTop()
                    }
        }
    }
}
