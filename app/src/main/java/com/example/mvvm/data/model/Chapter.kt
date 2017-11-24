package com.example.mvvm.data.model

import com.google.gson.annotations.SerializedName

/**
 * Copyright © 2017 AsianTech inc.
 * Created by vinh.huynh on 11/17/17.
 */
class Chapter(@SerializedName("chapterId") val chapterId: String,
              @SerializedName("position") val position: String, @SerializedName("source") val source: String)
