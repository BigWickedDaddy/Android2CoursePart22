package com.itis.android2coursepart22.domain.entity

data class BeerDetailModel {
    val abv: Double,
    val brewersTips: String,
    val contributedBy: String,
    val description: String,
    val ebc: Int,
    val firstBrewed: String,
    val foodPairing: List<String>,
    val ibu: Int,
    val id: Int,
    val name: String,
    val imageUrl: String,
}
