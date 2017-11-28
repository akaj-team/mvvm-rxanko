package com.example.mvvm.data.source

import android.util.Log.d
import com.example.mvvm.data.model.Chapter
import com.example.mvvm.data.model.Comic
import com.example.mvvm.data.source.remote.core.ApiService
import com.example.mvvm.data.model.PageComic
import com.example.mvvm.data.source.remote.ComicRemoteDataSource
import io.reactivex.Observable

/**
 * Copyright © 2017 AsianTech inc.
 * Created by vinh.huynh on 11/16/17.
 */
class ComicRepository : ComicDataSource {
    private val remoteDataSource = ComicRemoteDataSource()
    override fun getPageComic(chapterId: String): Observable<MutableList<PageComic>> {
        return remoteDataSource.getPageComic(chapterId)
    }

    override fun getChapter(comicId: String): Observable<MutableList<Chapter>> {
        return remoteDataSource.getChapter(comicId)
    }

    override fun getComic(): Observable<MutableList<Comic>> {
        return remoteDataSource.getComic().doOnError { d("xxx", "onErrorrrr") }
    }
}
