package com.itis.android2coursepart22.data.api.response


import com.google.gson.annotations.SerializedName

data class TempX(
    @SerializedName("unit")
    val unit: String,
    @SerializedName("value")
    val value: Int
)