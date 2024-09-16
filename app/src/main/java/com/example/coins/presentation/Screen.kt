package com.example.coins.presentation

sealed class Screen(val rout: String) {

    object CoinListScreen : Screen("Coin_list_screen")
    object CoinDetailScreen : Screen("Coin_detail_screen")

}