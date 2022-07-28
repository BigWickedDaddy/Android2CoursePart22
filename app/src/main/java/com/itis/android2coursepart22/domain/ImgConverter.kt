package com.itis.android2coursepart22.domain

import javax.inject.Inject

private const val BASE_IMAGE_URL = ""
private const val URL_SUFFIX = ""

class ImgConverter @Inject constructor() {
    fun setImageUrl(imageCode: String?): String = BASE_IMAGE_URL + imageCode + URL_SUFFIX
}