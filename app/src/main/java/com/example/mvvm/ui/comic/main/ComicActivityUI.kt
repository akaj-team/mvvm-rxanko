package com.example.mvvm.ui.comic.main

import android.support.v7.widget.GridLayoutManager
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.recyclerview.v7.recyclerView

/**
 * Copyright © 2017 AsianTech inc.
 * Created by vinh.huynh on 11/17/17.
 */
class ComicActivityUI(private val comicAdapter: ComicAdapter) : AnkoComponent<ComicActivity> {
    companion object {
        private const val NUM_COLUMN = 2
    }

    override fun createView(ui: AnkoContext<ComicActivity>) = with(ui) {
        recyclerView {
            layoutManager = GridLayoutManager(context, NUM_COLUMN)
            adapter = comicAdapter
            comicAdapter.onItemClick = { comic ->
                owner.viewComicDetail(comic.storyId.toString())
            }
        }
    }
}
