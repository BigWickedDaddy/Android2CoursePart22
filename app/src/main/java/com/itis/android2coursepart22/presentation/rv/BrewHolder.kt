package com.itis.android2coursepart22.presentation.rv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.itis.android2coursepart22.databinding.ItemMainBinding
import com.itis.android2coursepart22.domain.ImgConverter
import com.itis.android2coursepart22.domain.entity.BeerDetailModel

class BrewHolder (
    private val binding: ItemMainBinding,
    private val imageConverter: ImgConverter,
    private val onClick: (Int) -> (Unit)): RecyclerView.ViewHolder(binding.root){

    fun bind(item: BeerDetailModel) {
    with(binding) {
        tvDescription.text = item.name
        ivImage.load(imageConverter.setImageUrl(item.imageUrl))
        itemView.setOnClickListener {
            onClick(item.id)
        }
    }
}

    companion object {
        fun create(
            parent: ViewGroup,
            imageConverter: ImgConverter,
            onClick: (Int) -> Unit
        ) = BrewHolder(
            ItemMainBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            imageConverter,
            onClick
        )
    }
}