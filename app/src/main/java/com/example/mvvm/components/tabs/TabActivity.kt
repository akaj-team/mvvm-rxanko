package com.example.mvvm.components.tabs

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.example.mvvm.R
import org.jetbrains.anko.setContentView

/**
 * Copyright © 2016 AsianTech inc.
 * Created by vinh.huynh on 11/2/17.
 */
class TabActivity : AppCompatActivity() {
    private lateinit var tabActivityUI: TabActivityUI

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tabActivityUI = TabActivityUI(TabAdapter(supportFragmentManager))
        tabActivityUI.setContentView(this)
        setToolBar()
        initDrawerLayout()
        setupDrawerContent(tabActivityUI.navigation)
    }

    private fun initDrawerLayout() {
        val drawerToggle = ActionBarDrawerToggle(this, tabActivityUI.drawer, R.string.drawer_open, R.string.drawer_close)
        tabActivityUI.drawer.addDrawerListener(drawerToggle)
        drawerToggle.syncState()
    }

    private fun setToolBar() {
        setSupportActionBar(tabActivityUI.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
        supportActionBar?.setHomeButtonEnabled(false)
    }

    private fun setupDrawerContent(navigationView: NavigationView) {
        navigationView.setNavigationItemSelectedListener { item ->
            selectDrawerItem(item)
            true
        }
    }

    private fun selectDrawerItem(menuItem: MenuItem) {
        when (menuItem.itemId) {
            R.id.itemNewEst -> {
                if (tabActivityUI.viewpager.currentItem != 0) {
                    tabActivityUI.viewpager.currentItem = 0
                }
            }
            R.id.itemFavorite -> {
                if (tabActivityUI.viewpager.currentItem != 1) {
                    tabActivityUI.viewpager.currentItem = 1
                }
            }
            R.id.itemSetting -> {
                if (tabActivityUI.viewpager.currentItem != 2) {
                    tabActivityUI.viewpager.currentItem = 2
                }
            }
        }
        menuItem.isChecked = true
        title = menuItem.title
        tabActivityUI.drawer.closeDrawers()
    }

    /**
     * Update toolbar title
     */
    fun setToolBarTitle(title: String) {
        tabActivityUI.toolbar.setToolBarTitle(title)
    }
}
