package com.example.coins.data.repository

import com.example.coins.data.remote.CoinPaprikaApi
import com.example.coins.data.remote.dto.CoinDetailDto
import com.example.coins.data.remote.dto.CoinDto
import com.example.coins.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
) : CoinRepository {

    override suspend fun getCoins(): List<CoinDto> {

        return api.getCoins()

    }

    override suspend fun getCoin(coinId: String): CoinDetailDto {

        return api.getCoinByID(coinId)

    }


}