package com.example.mvvm.data.api.core

import com.example.mvvm.data.api.response.ChapterResponse
import com.example.mvvm.data.api.response.ComicResponse
import com.example.mvvm.data.api.response.LoginResponse
import com.example.mvvm.data.model.PageComic
import io.reactivex.Observable
import retrofit2.http.*

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

    @POST("login")
    @FormUrlEncoded
    fun login(@Field("email") email: String): Observable<LoginResponse>
}
