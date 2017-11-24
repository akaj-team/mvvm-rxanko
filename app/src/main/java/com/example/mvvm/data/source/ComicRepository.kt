package com.example.mvvm.data.source

import com.example.mvvm.data.api.core.ApiService
import com.example.mvvm.data.api.response.ChapterResponse
import com.example.mvvm.data.api.response.ComicResponse
import com.example.mvvm.data.model.PageComic
import io.reactivex.Observable

/**
 * Copyright © 2017 AsianTech inc.
 * Created by vinh.huynh on 11/16/17.
 */
class ComicRepository(private val apiService: ApiService) : ComicDataSource {
    override fun getPageComic(chapterId: String): Observable<MutableList<PageComic>> {
        return apiService.getPageComic(chapterId)
    }

    override fun getChapter(comicId: String): Observable<ChapterResponse> {
        return apiService.getChapterOfComic(comicId)
    }

    override fun getComic(): Observable<ComicResponse> {
        return apiService.getComic()
    }
}
