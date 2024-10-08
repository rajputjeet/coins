package com.example.coins.presentation.coin_list

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coins.common.Resource
import com.example.coins.domain.use_case.get_coins.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val getCoinsUseCase: GetCoinsUseCase
) : ViewModel() {

    private val TAG = "CoinListViewModel"

 private val _state = mutableStateOf(CoinListState())
    val state: State<CoinListState> = _state

    init {
        getCoins()
    }

    private fun getCoins(){

        getCoinsUseCase().onEach { result ->

            when(result){

                is Resource.Success ->{

                    _state.value = CoinListState(coins = result.data ?: emptyList())
                    Log.d(TAG, "Coins-> ${result.data}")

                }

                is Resource.Error ->{

                    _state.value = CoinListState(
                        error = result.massage ?: "An unexpected error occured."
                    )

                }

                is Resource.Loading ->{

                    _state.value = CoinListState(isLoading = true)

                }

            }

        }.launchIn(viewModelScope)

    }

}