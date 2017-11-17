package com.example.vinhhuynhlb.basemvvmkotlin.repository.api.core

import com.example.vinhhuynhlb.mvvm_kotlin_rxjava2.data.api.response.ChapterResponse
import com.example.vinhhuynhlb.mvvm_kotlin_rxjava2.data.api.response.ComicResponse
import com.example.vinhhuynhlb.mvvm_kotlin_rxjava2.data.model.PageComic
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Copyright © 2016 AsianTech inc.
 * Created by vinh.huynh on 10/16/17.
 */
interface ApiService {
    @GET("api-stories.php")
    fun getComic(): Observable<ComicResponse>

    @GET("api-chapters.php")
    fun getChapterOfComic(@Query("storyId") storyID: String): Observable<ChapterResponse>

    @GET("api-contents.php")
    fun getPageComic(@Query("chapterId") chapterId: String): Observable<MutableList<PageComic>>
}
