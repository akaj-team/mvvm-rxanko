package com.example.mvvm.ui.comic.detail

import android.support.v7.widget.LinearLayoutManager
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.recyclerview.v7.recyclerView

/**
 * Copyright © 2017 AsianTech inc.
 * Created by vinh.huynh on 11/17/17.
 */
class ComicDetailActivityUI(private val comicDetailAdapter: ComicDetailAdapter) : AnkoComponent<ComicDetailActivity> {
    override fun createView(ui: AnkoContext<ComicDetailActivity>) = with(ui) {
        recyclerView {
            layoutManager = LinearLayoutManager(context)
            adapter = comicDetailAdapter
            comicDetailAdapter.onItemClick = { chapter ->
                owner.viewChapterDetail(chapter.chapterId)
            }
        }
    }
}
