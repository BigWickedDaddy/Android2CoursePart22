package com.itis.android2coursepart22.presentation.view

import com.itis.android2coursepart22.domain.entity.BeerDetailModel
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle
import moxy.viewstate.strategy.alias.Skip

@AddToEndSingle
interface BrewDetailView : MvpView {
    fun updateView(beerDetailModel: BeerDetailModel)

    @Skip
    fun showError(throwable: Throwable)
}