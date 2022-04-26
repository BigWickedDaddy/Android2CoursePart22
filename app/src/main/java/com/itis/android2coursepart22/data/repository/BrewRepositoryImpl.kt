package com.itis.android2coursepart22.data.repository

import com.itis.android2coursepart22.data.api.BrewApi
import com.itis.android2coursepart22.data.api.mapper.BrewMapper
import com.itis.android2coursepart22.data.api.response.BrewResponse
import com.itis.android2coursepart22.domain.repository.BrewRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class BrewRepositoryImpl @Inject constructor(
    private val api: BrewApi,
    private val mapper: BrewMapper,
) :BrewRepository{
    override fun getBeerByIbu(ibu:Double):Single<BrewResponse> = api.getBeerByIbu(ibu)
        .map {
            TODO()
        }

    override fun getBeerByAbv(abv:Double):Single<BrewResponse> = api.getBeerByAbv(abv)
        .map {
            TODO()
        }

    override fun getRandomBeer():Single<BrewResponse> = api.getBeerByIbu()
        .map {
            TODO()
        }
}