package com.itis.android2coursepart22.presentation.presenter

import com.itis.android2coursepart22.domain.usecase.*
import com.itis.android2coursepart22.presentation.view.BrewDetailView
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.plusAssign
import io.reactivex.rxjava3.kotlin.subscribeBy
import moxy.MvpPresenter
import javax.inject.Inject

class DetailFragmentPresenter @Inject constructor(
    private val getBeerByAbvUseCase: GetBeerByAbvUseCase,
    private val getRandomBeerUseCase: GetRandomBeerUseCase,
    private val getBeerByIbuUseCase: GetBeerByIbuUseCase,
    private val getBeerByNameUseCase: GetBeerByNameUseCase,
    private val getBeerByIdUseCase: GetBeerByIdUseCase,

) : MvpPresenter<BrewDetailView>() {

    private val disposables = CompositeDisposable()

    override fun attachView(view: BrewDetailView?) {
        super.attachView(view)
    }

    override fun detachView(view: BrewDetailView?) {
        super.detachView(view)
    }

    override fun onDestroy() {
        disposables.dispose()
        super.onDestroy()
    }

    fun updateView(id:Int) {
        disposables += getBeerByIdUseCase(id)
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
                viewState.showLoading()
            }
            .doAfterTerminate {
                viewState.hideLoading()
            }
            .subscribeBy(
                onSuccess = {
                    viewState.updateView(it)
                }, onError = { error ->
                    viewState.showError(error)
                })
    }
}