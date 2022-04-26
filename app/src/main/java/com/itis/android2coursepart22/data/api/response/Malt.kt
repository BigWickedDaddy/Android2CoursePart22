package com.itis.android2coursepart22.data.api.response


import com.google.gson.annotations.SerializedName

data class Malt(
    @SerializedName("amount")
    val amount: AmountX,
    @SerializedName("name")
    val name: String
)