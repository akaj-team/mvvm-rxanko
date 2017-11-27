package com.example.mvvm.components.tabs.favorite

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.chauthai.overscroll.RecyclerViewBouncy
import org.jetbrains.anko.AnkoContext

/**
 * Copyright © 2016 AsianTech inc.
 * Created by vinh.huynh on 11/6/17.
 */
class FavoriteFragment : Fragment() {
    private lateinit var mAdapter: FavoriteAdapter
    private var data = mutableListOf<String>()
    lateinit var recyclerView: RecyclerViewBouncy

    companion object {
        fun newInstance() = FavoriteFragment()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        for (i in 0..20) {
            data.add(i.toString())
        }
        Log.d("VVVV", data.size.toString())
        mAdapter = FavoriteAdapter(context, data)
        return FavoriteFragmentUI(mAdapter).createView(AnkoContext.Companion.create(context, this, false))
    }

    fun onAddItemClick() {
        data.add("Vinh")
        mAdapter.notifyDataSetChanged()
        recyclerView.smoothScrollToPosition(data.size)
    }
}
