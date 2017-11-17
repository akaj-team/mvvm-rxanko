package com.example.vinhhuynhlb.mvvm_kotlin_rxjava2.comic.viewer

import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.matchParent
import org.jetbrains.anko.support.v4.viewPager
import org.jetbrains.anko.verticalLayout

/**
 * Copyright © 2017 AsianTech inc.
 * Created by vinh.huynh on 11/17/17.
 */
class ComicViewerActivityUI : AnkoComponent<ComicViewerActivity> {
    override fun createView(ui: AnkoContext<ComicViewerActivity>) = with(ui) {
        verticalLayout {
            lparams(matchParent, matchParent)
            owner.viewPager = viewPager {
            }.lparams(matchParent, matchParent)
        }
    }
}
