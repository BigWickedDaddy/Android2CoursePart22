package com.itis.android2coursepart22.data.repository

import com.itis.android2coursepart22.data.api.BrewApi
import com.itis.android2coursepart22.data.api.mapper.BrewMapper
import com.itis.android2coursepart22.data.api.response.BrewResponse
import com.itis.android2coursepart22.data.api.response.BrewResponseItem
import com.itis.android2coursepart22.domain.repository.BrewRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class BrewRepositoryImpl @Inject constructor(
    private val api: BrewApi,
    private val mapper: BrewMapper,
) :BrewRepository{
    override fun getBeerByIbu(ibu:Double):Single<BrewResponseItem> = api.getBeerByIbu(ibu)
        .map {
            mapper.mapBrewResponseItem(it)
        }

    override fun getBeerByAbv(abv:Double):Single<BrewResponseItem> = api.getBeerByAbv(abv)
        .map {
            mapper.mapBrewResponseItem(it)
        }

    override fun getRandomBeer():Single<BrewResponseItem> = api.getRandomBeer()
        .map {
            mapper.mapBrewResponseItem(it)
        }
}