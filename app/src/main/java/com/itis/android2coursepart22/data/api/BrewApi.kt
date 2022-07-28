package com.itis.android2coursepart22.data.api

import com.itis.android2coursepart22.data.api.response.BrewResponseItem
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface BrewApi {

    @GET("beers?ibu_gt={ibu}")
    fun getBeerByIbu(@Path("ibu") ibu:Double):Single<BrewResponseItem>

    @GET("beers?abv_gt={abv}")
    fun getBeerByAbv(@Path("abv") abv:Double):Single<BrewResponseItem>

    @GET("beers?beer_name={name}")
    fun getBeerByName(@Path("name") name: String):Single<BrewResponseItem>

    @GET("beers?ids={id}")
    fun getBeerById(@Path("id") id: Int):Single<BrewResponseItem>

    @GET("random")
    fun getRandomBeer():Single<BrewResponseItem>
}