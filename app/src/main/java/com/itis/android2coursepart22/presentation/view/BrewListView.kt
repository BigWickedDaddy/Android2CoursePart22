package com.itis.android2coursepart22.presentation.view

import com.itis.android2coursepart22.domain.entity.BeerDetailModel
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle
import moxy.viewstate.strategy.alias.OneExecution
import moxy.viewstate.strategy.alias.Skip

@AddToEndSingle
interface BrewListView : MvpView {
    fun showLoading()
    fun hideLoading()
    fun updateList(list: MutableList<BeerDetailModel>)
    @Skip
    fun showError(throwable: Throwable)
    @OneExecution
    fun openDetailsScreen(id: Int)
}