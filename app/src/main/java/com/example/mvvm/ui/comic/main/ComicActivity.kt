package com.example.mvvm.ui.comic.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.util.Log.d
import com.example.mvvm.data.source.remote.core.ApiClient
import com.example.mvvm.ui.comic.detail.ComicDetailActivity
import com.example.mvvm.data.model.Comic
import com.example.mvvm.data.source.ComicRepository
import com.example.mvvm.data.source.remote.core.ApiException
import com.example.mvvm_kotlin_rxjava2.util.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.setContentView

/**
 * Copyright © 2017 AsianTech inc.
 * Created by vinh.huynh on 11/17/17.
 */
class ComicActivity : AppCompatActivity() {
    private var data = mutableListOf<Comic>()
    private lateinit var adapter: ComicAdapter
    private lateinit var comicViewModel: ComicViewModel
    private val mSubscription: CompositeDisposable = CompositeDisposable()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = ComicAdapter(this, data)
        ComicActivityUI(adapter).setContentView(this)
        comicViewModel = ComicViewModel(SchedulerProvider.getInstance(), ComicRepository())
    }

    override fun onStart() {
        super.onStart()
        bindViewModel()
    }

    override fun onPause() {
        super.onPause()
        unbindViewModel()
    }

    fun viewComicDetail(comicId: String) {
        startActivity(intentFor<ComicDetailActivity>("comicId" to comicId))
    }

    private fun bindViewModel() {
        mSubscription.add(comicViewModel.getComic()
                .subscribe({
                    d("xxx", "count: ${it.size}")
                    data.addAll(it)
                    adapter.notifyDataSetChanged()
                }, {
                    Log.d("Error", it.message)
//                    Log.d("Error", (it as ApiException).text)
                }))
    }

    private fun unbindViewModel() {
        mSubscription.clear()
    }
}
