package com.itis.android2coursepart22.data.api

import com.itis.android2coursepart22.data.api.response.BrewResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface BrewApi {

    @GET("beers?ibu_gt={ibu}")
    fun getBeerByIbu(@Query("ibu") ibu:Double):Single<BrewResponse>

    @GET("beers?abv_gt={abv}")
    fun getBeerByAbv(@Query("abv") abv:Double):Single<BrewResponse>

    @GET("random")
    fun getRandomBeer():Single<BrewResponse>
}