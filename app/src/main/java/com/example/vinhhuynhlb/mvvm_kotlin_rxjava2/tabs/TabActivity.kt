package com.example.vinhhuynhlb.mvvm_kotlin_rxjava2.tabs

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.example.vinhhuynhlb.mvvm_kotlin_rxjava2.R
import org.jetbrains.anko.setContentView

/**
 * Copyright © 2016 AsianTech inc.
 * Created by vinh.huynh on 11/2/17.
 */
class TabActivity : AppCompatActivity() {
    private lateinit var globalUI: TabActivityUI

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        globalUI = TabActivityUI(TabAdapter(supportFragmentManager))
        globalUI.setContentView(this)
        setToolBar()
        initDrawerLayout()
        setupDrawerContent(globalUI.navigation)
    }

    private fun initDrawerLayout() {
        val drawerToggle = ActionBarDrawerToggle(this, globalUI.drawer, R.string.drawer_open, R.string.drawer_close)
        globalUI.drawer.addDrawerListener(drawerToggle)
        drawerToggle.syncState()
    }

    private fun setToolBar() {
        setSupportActionBar(globalUI.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
        supportActionBar?.setHomeButtonEnabled(false)
        globalUI.toolbar.setNavigationOnClickListener {
            if (globalUI.drawer.isDrawerOpen(GravityCompat.START)) {
                globalUI.drawer.closeDrawers()
            } else {
                globalUI.drawer.openDrawer(GravityCompat.START)
            }
        }
    }

    private fun setupDrawerContent(navigationView: NavigationView) {
        navigationView.setNavigationItemSelectedListener { item ->
            selectDrawerItem(item)
            true
        }
    }

    private fun selectDrawerItem(menuItem: MenuItem) {
        when (menuItem.itemId) {
            R.id.home_fragment -> {
            }
            R.id.photo_fragment -> {
            }
        }
        menuItem.isChecked = true
        title = menuItem.title
        globalUI.drawer.closeDrawers()
    }

    fun setToolBarTitle(title: String) {
        globalUI.toolbar.setToolBarTitle(title)
    }
}
