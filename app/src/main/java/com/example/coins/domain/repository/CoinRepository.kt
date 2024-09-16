package com.example.coins.domain.repository

import com.example.coins.data.remote.dto.CoinDetailDto
import com.example.coins.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoin(coinId: String): CoinDetailDto

}