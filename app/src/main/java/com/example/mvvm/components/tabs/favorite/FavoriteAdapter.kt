package com.example.mvvm.components.tabs.favorite

import android.content.Context
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.example.mvvm.R
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick

/**
 * Copyright © 2016 AsianTech inc.
 * Created by vinh.huynh on 10/31/17.
 */
open class FavoriteAdapter(private val context: Context,
                           private val data: MutableList<String>) : RecyclerView.Adapter<FavoriteAdapter.HomeViewHolder>() {
    override fun onBindViewHolder(holder: HomeViewHolder?, position: Int) {
        holder?.bindHolder(data[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        return HomeViewHolderUI()
                .createView(AnkoContext.create(context, parent, false))
                .tag as HomeViewHolder
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class HomeViewHolder(itemView: View, textLeft: TextView,
                               textRight: TextView) : RecyclerView.ViewHolder(itemView) {
        private var mTvLeft: TextView = textLeft
        private var mTvRight: TextView = textRight

        init {
            mTvRight.onClick {
                onItemClick(layoutPosition)
            }
        }

        fun bindHolder(item: String) {
            mTvLeft.text = item
            mTvRight.text = item + "Right"
        }
    }

    var onItemClick: (Int) -> Unit = {}

    inner class HomeViewHolderUI : AnkoComponent<ViewGroup> {
        override fun createView(ui: AnkoContext<ViewGroup>): View {
            var textLeft: TextView? = null
            var textRight: TextView? = null
            val itemView = with(ui) {
                linearLayout {
                    lparams(matchParent, dip(40))
                    orientation = LinearLayout.HORIZONTAL
                    textLeft = textView {
                        backgroundColor = ContextCompat.getColor(context, R.color.green)
                        gravity = Gravity.CENTER
                    }.lparams(dip(0), matchParent) {
                        weight = 2.toFloat()
                    }

                    textRight = textView {
                        backgroundColor = ContextCompat.getColor(context, R.color.greenLight)
                        gravity = Gravity.CENTER
                    }.lparams(dip(0), matchParent) {
                        weight = 1.toFloat()
                    }
                }
            }
            itemView.tag = HomeViewHolder(itemView, textLeft!!, textRight!!)
            return itemView
        }

    }
}