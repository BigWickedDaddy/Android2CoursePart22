package com.itis.android2coursepart22.data.api.mapper

import com.itis.android2coursepart22.data.api.response.BrewResponseItem
import com.itis.android2coursepart22.domain.entity.BeerDetailModel

class BrewMapper {
    fun mapBrewResponseItem(response : BrewResponseItem)=BeerDetailModel(
        abv = response.abv,
        brewersTips =response.brewersTips,
        contributedBy =response.contributedBy,
        description =response.description,
        ebc =response.ebc,
        firstBrewed=response.firstBrewed,
        foodPairing=response.foodPairing,
        ibu=response.ibu,
        id=response.id,
        name=response.name,
        imageUrl =response.imageUrl
    )
}