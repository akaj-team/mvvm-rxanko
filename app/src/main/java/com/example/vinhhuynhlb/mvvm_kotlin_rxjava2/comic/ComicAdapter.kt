package com.example.vinhhuynhlb.mvvm_kotlin_rxjava2.comic

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.android.lifecompanion.util.ScreenUtils
import com.bumptech.glide.Glide
import com.example.vinhhuynhlb.mvvm_kotlin_rxjava2.data.model.Comic
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick

/**
 * Copyright © 2017 AsianTech inc.
 * Created by vinh.huynh on 11/17/17.
 */
class ComicAdapter(private val context: Context, val data: MutableList<Comic>) : RecyclerView.Adapter<ComicAdapter.ComicViewHolder>() {

    override fun onBindViewHolder(holder: ComicViewHolder, position: Int) {
        holder.bindHolder(data[position].intro)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ComicAdapterUI()
            .createView(AnkoContext.create(context, parent, false))
            .tag as ComicViewHolder

    override fun getItemCount(): Int = data.size

    inner class ComicViewHolder(itemView: View?, private val imgComic: ImageView) : RecyclerView.ViewHolder(itemView) {
        init {
            imgComic.onClick {
                onItemClick(data[adapterPosition])
            }
        }

        fun bindHolder(url: String) {
            Glide.with(itemView.context)
                    .load(url)
                    .into(imgComic)
        }
    }

    var onItemClick: (Comic) -> Unit = {}

    inner class ComicAdapterUI : AnkoComponent<ViewGroup> {
        private lateinit var imgComic: ImageView
        override fun createView(ui: AnkoContext<ViewGroup>): View {
            val itemView = with(ui) {
                val screenWidth = ScreenUtils().getWidthScreen(owner.context)
                relativeLayout {
                    lparams(screenWidth / 2, wrapContent)
                    imgComic = imageView().lparams(matchParent, screenWidth / 2)
                }
            }
            itemView.tag = ComicViewHolder(itemView, imgComic)
            return itemView
        }
    }
}
