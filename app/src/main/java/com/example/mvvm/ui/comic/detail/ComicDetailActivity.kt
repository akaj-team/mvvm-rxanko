package com.example.mvvm.ui.comic.detail

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.example.mvvm.data.source.remote.core.ApiClient
import com.example.mvvm.ui.comic.main.ComicViewModel
import com.example.mvvm.ui.comic.viewer.ComicViewerActivity
import com.example.mvvm.data.model.Chapter
import com.example.mvvm.data.source.ComicRepository
import com.example.mvvm_kotlin_rxjava2.util.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.setContentView

/**
 * Copyright © 2017 AsianTech inc.
 * Created by vinh.huynh on 11/17/17.
 */
class ComicDetailActivity : AppCompatActivity() {
    private lateinit var comicViewModel: ComicViewModel
    private val mSubscription: CompositeDisposable = CompositeDisposable()
    private lateinit var comicId: String
    private lateinit var comicDetailAdapter: ComicDetailAdapter
    private var data = mutableListOf<Chapter>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        comicDetailAdapter = ComicDetailAdapter(this, data)
        ComicDetailActivityUI(comicDetailAdapter).setContentView(this)
        comicViewModel = ComicViewModel(SchedulerProvider.getInstance(), ComicRepository())
        comicId = intent.extras.getString("comicId")
    }

    override fun onStart() {
        super.onStart()
        bindViewModel()
    }

    fun viewChapterDetail(chapterId: String) {
        startActivity(intentFor<ComicViewerActivity>("chapterId" to chapterId))
    }

    private fun bindViewModel() {
        mSubscription.add(comicViewModel.getChapter(comicId)
                .subscribe({
                    data.addAll(it)
                    comicDetailAdapter.notifyDataSetChanged()
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
