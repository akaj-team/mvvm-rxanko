package com.example.mvvm.data.source.remote

import com.example.mvvm.data.model.Chapter
import com.example.mvvm.data.model.Comic
import com.example.mvvm.data.model.PageComic
import com.example.mvvm.data.source.ComicDataSource
import com.example.mvvm.data.source.remote.core.ApiClient
import io.reactivex.Observable

/**
 * Created by tien.hoang on 11/23/17.
 */
class ComicRemoteDataSource : ComicDataSource {
    override fun getChapter(comicId: String): Observable<MutableList<Chapter>> {
        return ApiClient.instance.getChapterOfComic(comicId).map { it.data }
    }

    override fun getPageComic(chapterId: String): Observable<MutableList<PageComic>> {
        return ApiClient.instance.getPageComic(chapterId)
    }

    override fun getComic(): Observable<MutableList<Comic>> {
        return ApiClient.instance.getComic().toObservable().flatMap { Observable.just(it.data) }
    }

}