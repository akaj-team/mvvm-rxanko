package com.example.vinhhuynhlb.mvvm_kotlin_rxjava2.data.repository

import com.example.vinhhuynhlb.basemvvmkotlin.repository.api.core.ApiService
import com.example.vinhhuynhlb.mvvm_kotlin_rxjava2.data.api.response.ChapterResponse
import com.example.vinhhuynhlb.mvvm_kotlin_rxjava2.data.api.response.ComicResponse
import com.example.vinhhuynhlb.mvvm_kotlin_rxjava2.data.model.PageComic
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
