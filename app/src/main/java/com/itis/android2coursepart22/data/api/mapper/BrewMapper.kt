package com.itis.android2coursepart22.data.api.mapper

import com.itis.android2coursepart22.data.api.response.BrewResponseItem
import com.itis.android2coursepart22.domain.entity.BeerDetailModel

interface BrewMapper {
    fun mapBrewResponseItem(response : BrewResponseItem):BeerDetailModel
}