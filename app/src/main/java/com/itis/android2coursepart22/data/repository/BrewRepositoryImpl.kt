package com.itis.android2coursepart22.data.repository

import com.itis.android2coursepart22.data.api.BrewApi
import com.itis.android2coursepart22.data.api.mapper.BrewMapper
import com.itis.android2coursepart22.domain.entity.BeerDetailModel
import com.itis.android2coursepart22.domain.repository.BrewRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class BrewRepositoryImpl @Inject constructor(
    private val api: BrewApi,
    private val mapper: BrewMapper,
) :BrewRepository{
    override fun getBeerByIbu(ibu:Double):Single<BeerDetailModel> = api.getBeerByIbu(ibu)
        .map {
            mapper.mapBrewResponseItem(it)
        }

    override fun getBeerByAbv(abv:Double):Single<BeerDetailModel> = api.getBeerByAbv(abv)
        .map {
            mapper.mapBrewResponseItem(it)
        }

    override fun getRandomBeer():Single<BeerDetailModel> = api.getRandomBeer()
        .map {
            mapper.mapBrewResponseItem(it)
        }

    override fun getBeerByName(name: String):Single<BeerDetailModel> = api.getBeerByName(name)
        .map {
            mapper.mapBrewResponseItem(it)
        }

    override fun getBeerById(id: Int):Single<BeerDetailModel> = api.getBeerById(id)
        .map {
            mapper.mapBrewResponseItem(it)
        }
}