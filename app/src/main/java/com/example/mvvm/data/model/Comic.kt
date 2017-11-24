package com.example.mvvm.data.model

import com.google.gson.annotations.SerializedName

/**
 * Copyright © 2017 AsianTech inc.
 * Created by vinh.huynh on 11/17/17.
 */
class Comic(@SerializedName("storyId") val storyId: String, @SerializedName("storyName") val storyName: String,
            @SerializedName("author") val author: String, @SerializedName("intro") val intro: String,
            @SerializedName("chaptersCount") val chaptersCount: String, @SerializedName("numberOfChapters") val numberOfChapters: String,
            @SerializedName("readCount") val readCount: String, @SerializedName("likeCount") val likeCount: String)
