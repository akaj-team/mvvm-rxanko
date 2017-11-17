package com.example.vinhhuynhlb.mvvm_kotlin_rxjava2.comic.viewer

import android.support.v4.view.PagerAdapter
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.vinhhuynhlb.mvvm_kotlin_rxjava2.R
import com.example.vinhhuynhlb.mvvm_kotlin_rxjava2.data.model.PageComic
import org.jetbrains.anko.*

/**
 * Copyright © 2017 AsianTech inc.
 * Created by vinh.huynh on 11/17/17.
 */
class ComicViewerAdapter(val data: MutableList<PageComic>) : PagerAdapter() {

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        return ComicViewerAdapterUI(data[position].source)
                .createView(AnkoContext.create(container.context, container, false))
    }

    override fun isViewFromObject(view: View, a: Any) = a == view

    override fun getCount(): Int {
        return data.size
    }

    inner class ComicViewerAdapterUI(private val src: String) : AnkoComponent<ViewGroup> {
        override fun createView(ui: AnkoContext<ViewGroup>): View {
            return with(ui) {
                verticalLayout {
                    lparams(matchParent, matchParent)
                    imageView(R.color.colorAccent) {
                        Glide.with(context).load(src).into(this)
                    }.lparams(matchParent, matchParent)
                }
            }
        }
    }
}
