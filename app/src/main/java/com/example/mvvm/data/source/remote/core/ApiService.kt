package com.example.mvvm.data.source.remote.core

import com.example.mvvm.data.model.Chapter
import com.example.mvvm.data.model.Comic
import com.example.mvvm.data.model.PageComic
import com.example.mvvm.data.model.User
import com.example.mvvm.data.source.remote.response.Response
import io.reactivex.Observable
import retrofit2.http.*

/**
 * Copyright © 2016 AsianTech inc.
 * Created by vinh.huynh on 10/16/17.
 */
interface ApiService {
    @GET("api-stories.php")
    fun getComic(): Observable<Response<MutableList<Comic>>>

    @GET("api-chapters.php")
    fun getChapterOfComic(@Query("storyId") storyID: String): Observable<Response<MutableList<Chapter>>>

    @GET("api-contents.php")
    fun getPageComic(@Query("chapterId") chapterId: String): Observable<MutableList<PageComic>>

    @POST("login")
    @FormUrlEncoded
    fun login(@Field("email") email: String): Observable<Response<User>>

    @GET("user/detail")
    fun getUserInfo(): Observable<Response<User>>
}
