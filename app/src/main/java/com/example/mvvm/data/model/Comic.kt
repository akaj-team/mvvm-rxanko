package com.example.mvvm.data.model

import com.google.gson.annotations.SerializedName

/**
 * Copyright © 2017 AsianTech inc.
 * Created by vinh.huynh on 11/17/17.
 */
data class Comic(@SerializedName("storyId") val storyId: String, @SerializedName("storyName") val storyName: String,
                 @SerializedName("author") val author: String, @SerializedName("intro") val intro: String,
                 @SerializedName("chaptersCount") val chaptersCount: String, @SerializedName("numberOfChapters") val numberOfChapters: String,
                 @SerializedName("readCount") val readCount: String, @SerializedName("likeCount") val likeCount: String) {

    companion object {
        val TABLE_NAME = "comic"
        val COLUMN_ID = "storyId"
        val COLUMN_NAME = "storyName"
        val COLUMN_AUTHOR = "author"
        val COLUMN_INTRO = "intro"
        val COLUMN_CHAPTER_COUNT = "chaptersCount"
        val COLUMN_CHAPTER_NUMBER = "numberOfChapters"
        val COLUMN_READ_COUNT = "readCount"
        val COLUMN_LIKE_COUNT = "likeCount"
    }
}
