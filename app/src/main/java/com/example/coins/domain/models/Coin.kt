package com.example.coins.domain.models

data class Coin(
    var id: String,
    var isActive: Boolean,
    var name: String,
    var rank: Int,
    var symbol: String,
)
