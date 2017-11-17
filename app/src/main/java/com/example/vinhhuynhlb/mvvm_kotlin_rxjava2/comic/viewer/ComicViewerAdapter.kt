package com.example.vinhhuynhlb.mvvm_kotlin_rxjava2.comic.viewer

import android.support.v4.view.PagerAdapter
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.vinhhuynhlb.mvvm_kotlin_rxjava2.data.model.PageComic
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.imageView

/**
 * Copyright © 2017 AsianTech inc.
 * Created by vinh.huynh on 11/17/17.
 */
class ComicViewerAdapter(val data: MutableList<PageComic>) : PagerAdapter() {

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view = ComicViewerAdapterUI(data[position].source)
                .createView(AnkoContext.create(container.context, container, false))
        container.addView(view)
        return view

    }

    override fun isViewFromObject(view: View, a: Any) = a == view

    override fun getCount(): Int {
        return data.size
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as ImageView)
    }

    inner class ComicViewerAdapterUI(private val src: String) : AnkoComponent<ViewGroup> {
        override fun createView(ui: AnkoContext<ViewGroup>): View {
            return with(ui) {
                imageView {
                    Glide.with(context).load(src).into(this)
                }
            }
        }
    }
}
