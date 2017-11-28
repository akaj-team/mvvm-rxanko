package com.example.mvvm.ui.comic.main

import android.util.Log.d
import com.example.mvvm.data.model.Chapter
import com.example.mvvm.data.model.Comic
import com.example.mvvm.data.model.PageComic
import com.example.mvvm.data.source.ComicDataSource
import com.example.mvvm_kotlin_rxjava2.util.SchedulerProvider
import io.reactivex.Observable

/**
 * Copyright © 2017 AsianTech inc.
 * Created by vinh.huynh on 11/17/17.
 */
class ComicViewModel(private val schedulerProvider: SchedulerProvider,
                     private val comicRepository: ComicDataSource) {



    fun getComic(): Observable<MutableList<Comic>> {
        return comicRepository.getComic()
                .observeOn(schedulerProvider.ui())
                .subscribeOn(schedulerProvider.io())
                .doOnNext { d("xxx", "onNext") }
                .doOnError { d("xxx", "onError") }
                .doOnSubscribe {
                    // Show dialog loading
                }
    }

    fun getChapter(comicId: String): Observable<MutableList<Chapter>> {
        return comicRepository.getChapter(comicId)
                .observeOn(schedulerProvider.ui())
                .subscribeOn(schedulerProvider.io())
                .doOnSubscribe {
                    // Show dialog loading
                }
                .doOnComplete {
                    // Hide dialog loading
                }
    }

    fun getPageComic(chapterId: String): Observable<MutableList<PageComic>> {
        return comicRepository.getPageComic(chapterId)
                .observeOn(schedulerProvider.ui())
                .subscribeOn(schedulerProvider.io())
                .doOnSubscribe {
                    // Show dialog loading
                }
                .doOnComplete {
                    // Hide dialog loading
                }
    }
}
