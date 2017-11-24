package com.example.mvvm.comic

import com.example.mvvm.data.api.response.ChapterResponse
import com.example.mvvm.data.api.response.ComicResponse
import com.example.mvvm.data.model.PageComic
import com.example.mvvm.data.source.ComicRepository
import com.example.mvvm_kotlin_rxjava2.util.SchedulerProvider
import io.reactivex.Observable

/**
 * Copyright © 2017 AsianTech inc.
 * Created by vinh.huynh on 11/17/17.
 */
class ComicViewModel(private val schedulerProvider: SchedulerProvider,
                     private val comicRepository: ComicRepository) {

    fun getComic(): Observable<ComicResponse> {
        return comicRepository.getComic()
                .observeOn(schedulerProvider.ui())
                .subscribeOn(schedulerProvider.io())
                .doOnSubscribe {
                    // Show dialog loading
                }.doOnComplete {
                    // Hide dialog loading
        }
    }

    fun getChapter(comicId: String): Observable<ChapterResponse> {
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
