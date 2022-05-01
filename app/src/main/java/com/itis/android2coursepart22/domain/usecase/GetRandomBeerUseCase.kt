package com.itis.android2coursepart22.domain.usecase

import com.itis.android2coursepart22.data.api.response.BrewResponseItem
import com.itis.android2coursepart22.domain.repository.BrewRepository
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject


class GetRandomBeerUseCase @Inject constructor(
    private val brewRepository: BrewRepository
) {
    operator fun invoke(): Single<BrewResponseItem> = brewRepository.getRandomBeer()
        .subscribeOn(Schedulers.io())
}