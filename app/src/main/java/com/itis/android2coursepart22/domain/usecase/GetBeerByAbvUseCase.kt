package com.itis.android2coursepart22.domain.usecase

import com.itis.android2coursepart22.domain.entity.BeerDetailModel
import com.itis.android2coursepart22.domain.repository.BrewRepository
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class GetBeerByAbvUseCase @Inject constructor(
    private val brewRepository: BrewRepository
) {
    operator fun invoke(
        abv : Double
    ): Single<BeerDetailModel> = brewRepository.getBeerByAbv(abv)
        .subscribeOn(Schedulers.io())
}