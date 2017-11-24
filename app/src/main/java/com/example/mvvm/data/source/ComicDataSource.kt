package com.example.mvvm.data.source

import com.example.mvvm.data.api.response.ChapterResponse
import com.example.mvvm.data.api.response.ComicResponse
import com.example.mvvm.data.model.PageComic
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
