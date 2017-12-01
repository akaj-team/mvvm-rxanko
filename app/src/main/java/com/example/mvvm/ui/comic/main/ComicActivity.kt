package com.example.mvvm.ui.comic.main

import android.os.Bundle
import com.example.mvvm.data.model.Comic
import com.example.mvvm.data.source.ComicRepository
import com.example.mvvm.data.source.remote.core.ApiClient
import com.example.mvvm.data.source.remote.core.CallbackWrapper
import com.example.mvvm.ui.BaseActivity
import com.example.mvvm.ui.comic.detail.ComicDetailActivity
import com.example.mvvm_kotlin_rxjava2.util.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.setContentView

/**
 * Copyright © 2017 AsianTech inc.
 * Created by vinh.huynh on 11/17/17.
 */
class ComicActivity : BaseActivity() {
    private var data = mutableListOf<Comic>()
    private lateinit var adapter: ComicAdapter
    private lateinit var comicViewModel: ComicViewModel
    private val mSubscription: CompositeDisposable = CompositeDisposable()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = ComicAdapter(this, data)
        ComicActivityUI(adapter).setContentView(this)
        comicViewModel = ComicViewModel(SchedulerProvider.getInstance(), ComicRepository(ApiClient.getApiService()))
    }


    fun viewComicDetail(comicId: String) {
        startActivity(intentFor<ComicDetailActivity>("comicId" to comicId))
    }

    override fun bindViewModel() {
        mSubscription.add(comicViewModel.getComic()
                .subscribeWith(object : CallbackWrapper<MutableList<Comic>>(this) {
                    override fun onSuccess(t: MutableList<Comic>) {
                        data.addAll(t)
                        adapter.notifyDataSetChanged()
                    }
                }))
    }

    override fun unbindViewModel() {
    }
}
