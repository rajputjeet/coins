package com.example.coins.domain.use_case.get_coin

import com.example.coins.common.Resource
import com.example.coins.data.remote.dto.toCoinDetail
import com.example.coins.domain.models.CoinDetail
import com.example.coins.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val coinsRepository: CoinRepository
) {

    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {

        try {

            emit(Resource.Loading())

            val coin = coinsRepository.getCoin(coinId).toCoinDetail()
            emit(Resource.Success(coin))

        } catch (e: HttpException) {

            emit(Resource.Error(e.localizedMessage ?: "An un expected error occured"))


        } catch (e: IOException) {

            emit(Resource.Error(e.localizedMessage ?: "Couldn't reach server, Check your internet connection"))

        }

    }

}