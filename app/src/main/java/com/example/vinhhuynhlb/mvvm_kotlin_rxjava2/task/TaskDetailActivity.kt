package com.example.vinhhuynhlb.mvvm_kotlin_rxjava2.task

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import org.jetbrains.anko.*

/**
 * Copyright © 2017 AsianTech inc.
 * Created by vinh.huynh on 11/16/17.
 */
class TaskDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        TaskDetailActivityUI().setContentView(this)
    }
}

class TaskDetailActivityUI : AnkoComponent<TaskDetailActivity> {
    override fun createView(ui: AnkoContext<TaskDetailActivity>) = with(ui) {
        relativeLayout {
            textView("TextDetail Activity").lparams(wrapContent, wrapContent) {
                centerInParent()
            }
        }
    }
}
