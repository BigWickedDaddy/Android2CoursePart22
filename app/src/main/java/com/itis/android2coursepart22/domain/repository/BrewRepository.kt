package com.itis.android2coursepart22.domain.repository

import com.itis.android2coursepart22.domain.entity.BeerDetailModel
import io.reactivex.rxjava3.core.Single

interface BrewRepository {
    fun getBeerByIbu(ibu:Double):Single<BeerDetailModel>
    fun getBeerByAbv(abv:Double):Single<BeerDetailModel>
    fun getBeerByName(name:String):Single<BeerDetailModel>
    fun getBeerById(id:Int):Single<BeerDetailModel>
    fun getRandomBeer():Single<BeerDetailModel>
}