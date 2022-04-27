package com.itis.android2coursepart22.domain.repository

import com.itis.android2coursepart22.data.api.response.BrewResponseItem
import io.reactivex.rxjava3.core.Single

interface BrewRepository {
    fun getBeerByIbu(ibu:Double): Single<BrewResponseItem>
    fun getBeerByAbv(abv:Double):Single<BrewResponseItem>
    fun getRandomBeer():Single<BrewResponseItem>
}