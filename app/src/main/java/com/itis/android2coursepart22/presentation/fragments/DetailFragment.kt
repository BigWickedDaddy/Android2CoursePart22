package com.itis.android2coursepart22.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import coil.load
import com.google.android.material.snackbar.Snackbar
import com.itis.android2coursepart22.R
import com.itis.android2coursepart22.databinding.FragmentDetailBinding
import com.itis.android2coursepart22.domain.ImgConverter
import com.itis.android2coursepart22.domain.entity.BeerDetailModel
import com.itis.android2coursepart22.presentation.presenter.DetailFragmentPresenter
import com.itis.android2coursepart22.presentation.rv.BrewAdapter
import com.itis.android2coursepart22.presentation.view.BrewDetailView
import dagger.hilt.android.AndroidEntryPoint
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import retrofit2.HttpException
import javax.inject.Inject

@AndroidEntryPoint
class DetailFragment : MvpAppCompatFragment(R.layout.fragment_detail), BrewDetailView {

    private var binding: FragmentDetailBinding? = null
    private var brewadapter: BrewAdapter? = null

    private val beerId: Int by lazy {
        arguments?.getInt("BEER_ID") ?: -1
    }
    @Inject
    @InjectPresenter
    lateinit var presenter: DetailFragmentPresenter

    @ProvidePresenter
    fun providePresenter(): DetailFragmentPresenter = presenter

    @Inject
    lateinit var converter: ImgConverter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_detail,container,false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentDetailBinding.bind(view)
        presenter.updateView(beerId)
    }

    override fun updateView(beer: BeerDetailModel) {
        with(binding) {
            this!!.tvName.text = beer.name
            tvFirstbrewed.text = beer.firstBrewed
            tvDescription.text = beer.description
            tvContributedby.text = beer.contributedBy
            tvAbv.text= beer.abv.toString()
            tvBrewertips.text = beer.brewersTips
            tvId.text = beer.id.toString()
            tvFoodpairing.text= beer.foodPairing.toString()
            ivBeerim.load(converter.setImageUrl(beer.imageUrl))
        }
    }

    override fun showError(throwable: Throwable) {
        when (throwable) {
            is HttpException -> {
                showMessage("CONNECTION ERROR")
            }
            is NullPointerException -> {
                showMessage("DATA ERROR")
            }
            else -> {
                showMessage("ERROR")
            }
        }
    }

    private fun showMessage(message: String) {
        Snackbar.make(
            requireActivity().findViewById(R.id.container),
            message,
            Snackbar.LENGTH_LONG
        ).show()
    }

    override fun onDestroy() {
        binding = null
        super.onDestroy()
    }
}