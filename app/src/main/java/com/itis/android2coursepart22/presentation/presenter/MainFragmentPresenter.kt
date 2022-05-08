package com.itis.android2coursepart22.presentation.presenter

import com.itis.android2coursepart22.domain.entity.BeerDetailModel
import com.itis.android2coursepart22.domain.usecase.GetBeerByIbuUseCase
import com.itis.android2coursepart22.domain.usecase.GetBeerByNameUseCase
import com.itis.android2coursepart22.domain.usecase.GetRandomBeerUseCase
import com.itis.android2coursepart22.presentation.view.BrewListView
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.plusAssign
import io.reactivex.rxjava3.kotlin.subscribeBy
import moxy.MvpPresenter
import javax.inject.Inject

class MainFragmentPresenter @Inject constructor(
    private val getRandomBeerUseCase: GetRandomBeerUseCase,
    private val getBeerByIbuUseCase: GetBeerByIbuUseCase,
    private val getBeerByNameUseCase: GetBeerByNameUseCase,
) : MvpPresenter<BrewListView>() {

    private val disposables = CompositeDisposable()

//    override fun onFirstViewAttach() {
//        super.onFirstViewAttach()
//    }

    override fun attachView(view: BrewListView?) {
        super.attachView(view)
    }

    override fun detachView(view: BrewListView?) {
        super.detachView(view)
    }

    fun showRandomList() {
        disposables += getRandomBeerUseCase.invoke()
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
                viewState.showLoading()
            }.doAfterTerminate {
                viewState.hideLoading()
            }
            .subscribeBy(onSuccess = {
                viewState.updateList(listOf(it) as MutableList<BeerDetailModel>)
            }, onError = { error ->
                viewState.showError(error)
                error.stackTrace.forEach { println(it) }
            })
    }

    fun showNameList(name: String){
        disposables += getBeerByNameUseCase(name)
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
                viewState.showLoading()
            }.doAfterTerminate {
                viewState.hideLoading()
            }
            .subscribeBy(onSuccess = {
                viewState.updateList(listOf(it) as MutableList<BeerDetailModel>)
            }, onError = { error ->
                viewState.showError(error)
            })
    }

    fun loadListBySearch(ibu: Double){
        disposables += getBeerByIbuUseCase.invoke(ibu)
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
                viewState.showLoading()
            }.doAfterTerminate {
                viewState.hideLoading()
            }
            .subscribeBy(onSuccess = {
                viewState.updateList(listOf(it) as MutableList<BeerDetailModel>)
            }, onError = { error ->
                viewState.showError(error)
            })
    }

    override fun onDestroy() {
        disposables.dispose()
        super.onDestroy()
    }
}