package com.example.vinhhuynhlb.mvvm_kotlin_rxjava2.view

import android.annotation.SuppressLint
import android.content.Context
import android.support.v4.content.ContextCompat
import android.support.v7.widget.Toolbar
import android.view.Gravity
import android.view.View
import android.view.ViewManager
import android.widget.ImageView
import android.widget.TextView
import com.example.vinhhuynhlb.mvvm_kotlin_rxjava2.R
import org.jetbrains.anko.*
import org.jetbrains.anko.custom.ankoView
import org.jetbrains.anko.sdk25.coroutines.onClick

@SuppressLint("ViewConstructor")
/**
 * Copyright © 2017 AsianTech inc.
 * Created by vinh.huynh on 11/23/17.
 */
class HeaderBarView(private val onHeaderBarListener: OnHeaderBarListener,
                    context: Context) : Toolbar(context) {
    private lateinit var tvToolBarTitle: TextView
    private lateinit var imgToolBarLeft: ImageView
    private lateinit var imgToolBarRight: ImageView

    init {
        AnkoContext.createDelegate(this).apply {
            linearLayout {
                lparams(matchParent, dip(48))
                gravity = Gravity.CENTER_VERTICAL
                weightSum = 7f
                imgToolBarLeft = imageView(R.drawable.ic_header_menu) {
                    onClick {
                        onHeaderBarListener.onLeftMenuClick()
                    }
                }.lparams(dip(0), wrapContent) {
                    weight = 1f
                }

                tvToolBarTitle = textView(R.string.material_toolbar).lparams(dip(0), wrapContent) {
                    weight = 4f
                }

                imageView(R.drawable.ic_header_search) {
                    onClick {
                        onHeaderBarListener.onSearchClick()
                    }
                }.lparams(dip(0), wrapContent) {
                    weight = 1f
                }

                imgToolBarRight = imageView(R.drawable.ic_header_share) {
                    onClick {
                        onHeaderBarListener.onShareClick()
                    }
                }.lparams(dip(0), wrapContent) {
                    weight = 1f
                }
            }.applyRecursively { view: View ->
                when (view) {
                    is TextView -> {
                        view.textColor = ContextCompat.getColor(context, android.R.color.white)
                        view.textSize = 20f
                    }
                }
            }
        }
    }

    fun setToolBarTitle(title: String): HeaderBarView {
        tvToolBarTitle.text = title
        return this
    }

    fun setToolBarLeftBackground(rs: Int): HeaderBarView {
        imgToolBarLeft.backgroundResource = rs
        return this
    }

    fun setToolBarRightBackground(rs: Int): HeaderBarView {
        imgToolBarRight.backgroundResource = rs
        return this
    }
}

interface OnHeaderBarListener {
    fun onLeftMenuClick() {}
    fun onSearchClick() {}
    fun onShareClick() {}
}

@Suppress("NOTHING_TO_INLINE")
inline fun ViewManager.headerBar(onHeaderBarListener: OnHeaderBarListener, idView: Int = -1)
        = myHeaderBar(onHeaderBarListener) {
    id = idView
}

inline fun ViewManager.myHeaderBar(onHeaderBarListener: OnHeaderBarListener,
                                   init: HeaderBarView.() -> Unit): HeaderBarView {
    return ankoView({ HeaderBarView(onHeaderBarListener, it) }, theme = 0, init = init)
}
