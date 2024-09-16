package com.example.coins.data.remote.dto

import com.example.coins.domain.models.Coin

data class CoinDto(
    var id: String,
    var is_active: Boolean,
    var isNew: Boolean,
    var name: String,
    var rank: Int,
    var symbol: String,
    var type: String
)

fun CoinDto.toCoin(): Coin {

    return Coin(
        id = id,
        isActive = is_active,
        name = name,
        rank = rank,
        symbol = symbol,
    )
}