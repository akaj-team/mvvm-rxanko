package com.example.mvvm.ui.comic.viewer

import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.example.mvvm.data.source.remote.core.ApiClient
import com.example.mvvm.ui.comic.main.ComicViewModel
import com.example.mvvm.data.model.PageComic
import com.example.mvvm.data.source.ComicRepository
import com.example.mvvm_kotlin_rxjava2.util.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import org.jetbrains.anko.setContentView

/**
 * Copyright © 2017 AsianTech inc.
 * Created by vinh.huynh on 11/17/17.
 */
class ComicViewerActivity : AppCompatActivity() {
    private lateinit var comicViewModel: ComicViewModel
    private val mSubscription: CompositeDisposable = CompositeDisposable()
    private val data = mutableListOf<PageComic>()
    private lateinit var comicViewerAdapter: ComicViewerAdapter
    private lateinit var chapterId: String
    lateinit var viewPager: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ComicViewerActivityUI().setContentView(this)
        comicViewModel = ComicViewModel(SchedulerProvider.getInstance(), ComicRepository())
        chapterId = intent.extras.getString("chapterId")
    }

    override fun onStart() {
        super.onStart()
        bindViewModel()
    }

    private fun bindViewModel() {
        mSubscription.add(comicViewModel.getPageComic("15066574594015")
                .subscribe({
                    data.addAll(it)
                    comicViewerAdapter = ComicViewerAdapter(data)
                    viewPager.adapter = comicViewerAdapter
                    Log.d("VVVV", data.size.toString())
                }, {
                    Log.d("VVVV", it.message)
                }))
    }

    override fun onPause() {
        super.onPause()
        unBindViewModel()
    }

    private fun unBindViewModel() {
        mSubscription.clear()
    }
}