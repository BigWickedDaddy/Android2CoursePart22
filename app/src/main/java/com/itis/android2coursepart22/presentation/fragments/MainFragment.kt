package com.itis.android2coursepart22.presentation.fragments

import android.os.Bundle
import android.view.View
import android.widget.SearchView
import androidx.core.view.isVisible
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.itis.android2coursepart22.R
import com.itis.android2coursepart22.databinding.FragmentMainBinding
import com.itis.android2coursepart22.domain.ImgConverter
import com.itis.android2coursepart22.domain.entity.BeerDetailModel
import com.itis.android2coursepart22.presentation.presenter.MainFragmentPresenter
import com.itis.android2coursepart22.presentation.rv.BrewAdapter
import com.itis.android2coursepart22.presentation.view.BrewListView
import dagger.hilt.android.AndroidEntryPoint
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter
import retrofit2.HttpException
import javax.inject.Inject


@AndroidEntryPoint
class MainFragment : MvpAppCompatFragment(R.layout.fragment_main), BrewListView {

    private var binding: FragmentMainBinding? = null
    private lateinit var brewAdapter: BrewAdapter

    @Inject
    @InjectPresenter
    lateinit var presenter: MainFragmentPresenter

//    @ProvidePresenter
//    fun providePresenter(): MainFragmentPresenter = presenter

    @Inject
    lateinit var converter: ImgConverter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentMainBinding.bind(view)
        initRecyclerView()

        presenter.showRandomList()
        initSearchView()
    }

    private fun initSearchView() {
        binding?.searchView?.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let {
                    presenter.showNameList(it)
                }
                return false
            }
            override fun onQueryTextChange(newText: String): Boolean {
                return false
            }
        })
    }

    private fun initRecyclerView(){
        brewAdapter = BrewAdapter(converter) { id ->
            openDetailsScreen(id)
        }
        binding?.rvList?.apply {
            adapter = brewAdapter
        }
    }

    override fun showLoading() {
        binding?.progressMain?.isVisible = true
    }

    override fun hideLoading() {
        binding?.progressMain?.isVisible = false
    }

    override fun updateList(list: MutableList<BeerDetailModel>) {
            brewAdapter.submitList(list)
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

    override fun openDetailsScreen(id: Int) {
        val bundle = Bundle().apply {
            putInt("BEER_ID", id)
        }
        val options = NavOptions.Builder()
            .setLaunchSingleTop(true)
            .build()
        findNavController().navigate(
            R.id.action_mainFragment_to_detailFragment,
            bundle,
            options
        )
    }

    companion object {
//        fun newInstance() = MainFragment()
    }

    override fun onDestroy() {
        binding = null
        super.onDestroy()
    }
}