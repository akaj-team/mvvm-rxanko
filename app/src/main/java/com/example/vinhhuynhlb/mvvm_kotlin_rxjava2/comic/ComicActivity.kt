package com.example.vinhhuynhlb.mvvm_kotlin_rxjava2.comic

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.example.vinhhuynhlb.basemvvmkotlin.repository.api.core.ApiClient
import com.example.vinhhuynhlb.mvvm_kotlin_rxjava2.comic.detail.ComicDetailActivity
import com.example.vinhhuynhlb.mvvm_kotlin_rxjava2.data.model.Comic
import com.example.vinhhuynhlb.mvvm_kotlin_rxjava2.data.repository.ComicRepository
import com.example.vinhhuynhlb.mvvm_kotlin_rxjava2.util.SchedulerProvider
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
        comicViewModel = ComicViewModel(SchedulerProvider.getInstance(), ComicRepository(ApiClient.getApiService()))
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
                    data.addAll(it.data)
                    adapter.notifyDataSetChanged()
                }, {
                    Log.d("VVVV", it.message)
                }))
    }

    private fun unbindViewModel() {
        mSubscription.clear()
    }
}
