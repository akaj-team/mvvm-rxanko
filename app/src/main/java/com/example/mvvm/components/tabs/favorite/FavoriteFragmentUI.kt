package com.example.mvvm.components.tabs.favorite

import android.support.v7.widget.LinearLayoutManager
import android.view.ViewManager
import com.chauthai.overscroll.RecyclerViewBouncy
import org.jetbrains.anko.*
import org.jetbrains.anko.custom.ankoView
import org.jetbrains.anko.sdk25.coroutines.onClick

/**
 * Copyright © 2016 AsianTech inc.
 * Created by vinh.huynh on 11/6/17.
 */
class FavoriteFragmentUI(private val adap: FavoriteAdapter) : AnkoComponent<FavoriteFragment> {

    companion object {
        private const val ID_BTN_ADD = 100
    }

    override fun createView(ui: AnkoContext<FavoriteFragment>) = with(ui) {
        relativeLayout {
            owner.recyclerView = recyclerViewBouncy()
                    .lparams(matchParent, matchParent) {
                        above(ID_BTN_ADD)
                    }
            button("Add Item") {
                id = ID_BTN_ADD
                onClick {
                    owner.onAddItemClick()
                }
            }.lparams(matchParent, dip(50)) {
                alignParentBottom()
            }
        }
    }

    @Suppress("NOTHING_TO_INLINE")
    private inline fun ViewManager.recyclerViewBouncy() = myRecyclerViewBouncy {
        layoutManager = LinearLayoutManager(context)
        adapter = adap
    }

    private inline fun ViewManager.myRecyclerViewBouncy(init: RecyclerViewBouncy.() -> Unit): RecyclerViewBouncy {
        return ankoView({ RecyclerViewBouncy(it) }, theme = 0, init = init)
    }
}
