package com.example.mvvm.data.source

import com.example.mvvm.data.model.Chapter
import com.example.mvvm.data.model.Comic
import com.example.mvvm.data.model.PageComic
import io.reactivex.Observable

/**
 * Copyright © 2017 AsianTech inc.
 * Created by vinh.huynh on 11/16/17.
 */
interface ComicDataSource {
    fun getComic(): Observable<MutableList<Comic>>

    fun getChapter(comicId: String): Observable<MutableList<Chapter>>

    fun getPageComic(chapterId: String): Observable<MutableList<PageComic>>
}
