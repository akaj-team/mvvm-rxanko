package com.example.mvvm.data.model

import com.google.gson.annotations.SerializedName

/**
 * Copyright © 2017 AsianTech inc.
 * Created by vinh.huynh on 11/17/17.
 */
class Comic() {
    @SerializedName("storyId")
    lateinit var storyId: String
    @SerializedName("storyName")
    lateinit var  storyName: String
    @SerializedName("author")
    lateinit var  author: String
    @SerializedName("intro")
    lateinit var  intro: String
    @SerializedName("chaptersCount")
    lateinit var  chaptersCount: String
    @SerializedName("numberOfChapters")
    lateinit var  numberOfChapters: String
    @SerializedName("readCount")
    lateinit var  readCount: String
    @SerializedName("likeCount")
    lateinit var  likeCount: String
}
