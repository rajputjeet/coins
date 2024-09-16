package com.example.coins.presentation.coin_detail

import com.example.coins.domain.models.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin : CoinDetail? = null,
    val error : String = ""
)
