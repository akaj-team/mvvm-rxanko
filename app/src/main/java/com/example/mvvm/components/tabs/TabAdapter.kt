package com.example.mvvm.components.tabs

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.example.mvvm.components.tabs.favorite.FavoriteFragment
import com.example.mvvm.components.tabs.newest.NewestFragment
import com.example.mvvm.components.tabs.setting.SettingFragment

/**
 * Copyright © 2016 AsianTech inc.
 * Created by vinh.huynh on 11/7/17.
 */
class TabAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {
    private val tabTitles = arrayOf("Newest", "Favorite", "Setting")

    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> return NewestFragment.newInstance()
            1 -> return FavoriteFragment.newInstance()
        }
        return SettingFragment.newInstance()
    }

    override fun getPageTitle(position: Int): CharSequence {
        return tabTitles[position]
    }

    override fun getCount() = 3
}