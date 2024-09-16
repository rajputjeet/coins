package com.example.coins.domain.use_case.get_coins

import com.example.coins.common.Resource
import com.example.coins.data.remote.dto.toCoin
import com.example.coins.domain.models.Coin
import com.example.coins.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val coinsRepository: CoinRepository
) {

    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {

        try {

            emit(Resource.Loading())

            val coins = coinsRepository.getCoins().map { it.toCoin() }
            emit(Resource.Success(coins))

        } catch (e: HttpException) {

            emit(Resource.Error(e.localizedMessage ?: "An un expected error occured"))


        } catch (e: IOException) {

            emit(Resource.Error(e.localizedMessage ?: "Couldn't reach server, Check your internet connection"))

        }

    }

}