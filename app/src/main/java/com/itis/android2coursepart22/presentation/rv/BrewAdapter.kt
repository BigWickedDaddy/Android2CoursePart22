package com.itis.android2coursepart22.presentation.rv

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.itis.android2coursepart22.domain.ImgConverter
import com.itis.android2coursepart22.domain.entity.BeerDetailModel

class BrewAdapter (
    private val imageConverter: ImgConverter,
    private val onClick: (Int) -> (Unit)
): ListAdapter<BeerDetailModel, BrewHolder>(BeerDiffUtilsCallback()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BrewHolder
            = BrewHolder.create(parent, imageConverter, onClick)

    override fun onBindViewHolder(holder: BrewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun submitList(list: MutableList<BeerDetailModel>?) {
        super.submitList(
            if (list == null) null
            else ArrayList(list)
        )
    }
}

class BeerDiffUtilsCallback : DiffUtil.ItemCallback<BeerDetailModel>() {

    override fun areItemsTheSame(
        oldItem: BeerDetailModel,
        newItem: BeerDetailModel
    ): Boolean = oldItem.id == newItem.id

    override fun areContentsTheSame(
        oldItem: BeerDetailModel,
        newItem: BeerDetailModel
    ): Boolean = oldItem == newItem
}