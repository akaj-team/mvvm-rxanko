package com.example.vinhhuynhlb.mvvm_kotlin_rxjava2.data.repository

import com.example.vinhhuynhlb.mvvm_kotlin_rxjava2.data.api.response.ChapterResponse
import com.example.vinhhuynhlb.mvvm_kotlin_rxjava2.data.api.response.ComicResponse
import com.example.vinhhuynhlb.mvvm_kotlin_rxjava2.data.model.PageComic
import io.reactivex.Observable

/**
 * Copyright © 2017 AsianTech inc.
 * Created by vinh.huynh on 11/16/17.
 */
interface ComicDataSource {
    fun getComic(): Observable<ComicResponse>

    fun getChapter(comicId: String): Observable<ChapterResponse>

    fun getPageComic(chapterId: String): Observable<MutableList<PageComic>>
}
