package com.example.vinhhuynhlb.mvvm_kotlin_rxjava2.task.add

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import org.jetbrains.anko.*

/**
 * Copyright © 2017 AsianTech inc.
 * Created by vinh.huynh on 11/16/17.
 */
class AddTaskActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AddTaskActivityUI().setContentView(this)
    }
}

class AddTaskActivityUI : AnkoComponent<AddTaskActivity> {
    override fun createView(ui: AnkoContext<AddTaskActivity>) = with(ui) {
        relativeLayout {
            textView("Add Task Activity").lparams(wrapContent, wrapContent) {
                centerInParent()
            }
        }
    }
}
