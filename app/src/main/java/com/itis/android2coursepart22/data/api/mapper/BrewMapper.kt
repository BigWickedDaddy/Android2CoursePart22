package com.itis.android2coursepart22.data.api.mapper

import com.itis.android2coursepart22.data.api.response.BrewResponseItem

interface BrewMapper {
    fun mapBrewResponseItem(response : BrewResponseItem):BrewResponseItem
}