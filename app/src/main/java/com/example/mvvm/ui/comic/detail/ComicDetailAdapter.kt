package com.example.mvvm.ui.comic.detail

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.mvvm.data.model.Chapter
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick

/**
 * Copyright © 2017 AsianTech inc.
 * Created by vinh.huynh on 11/17/17.
 */
class ComicDetailAdapter(private val context: Context, val data: MutableList<Chapter>) : RecyclerView.Adapter<ComicDetailAdapter.ComicDetailViewHolder>() {

    override fun onBindViewHolder(holder: ComicDetailViewHolder, position: Int) {
        holder.bindHolder(data[position].position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ComicAdapterUI()
            .createView(AnkoContext.create(context, parent, false))
            .tag as ComicDetailViewHolder

    override fun getItemCount(): Int = data.size

    inner class ComicDetailViewHolder(itemView: View?, private val tvChapter: TextView) : RecyclerView.ViewHolder(itemView) {
        init {
            tvChapter.onClick {
                onItemClick(data[adapterPosition])
            }
        }

        fun bindHolder(numChap: String) {
            tvChapter.text = "Chapter: ${numChap}"
        }
    }

    var onItemClick: (Chapter) -> Unit = {}

    inner class ComicAdapterUI : AnkoComponent<ViewGroup> {
        private lateinit var tvChapter: TextView
        override fun createView(ui: AnkoContext<ViewGroup>): View {
            val itemView = with(ui) {
                verticalLayout {
                    lparams(matchParent, dip(30))
                    tvChapter = textView {
                        textSize = 16f
                    }.lparams(matchParent, matchParent) {
                        padding = dip(5)
                    }
                }
            }
            itemView.tag = ComicDetailViewHolder(itemView, tvChapter)
            return itemView
        }
    }
}