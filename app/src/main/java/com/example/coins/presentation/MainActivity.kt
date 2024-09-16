package com.example.coins.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.coins.presentation.coin_detail.CoinDetailScreen
import com.example.coins.presentation.coin_list.CoinListScreen
import com.example.coins.presentation.ui.theme.CoinsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoinsTheme {
                Surface(color = MaterialTheme.colorScheme.background) {

                    val navController = rememberNavController()
                    NavHost(navController = navController,
                        startDestination = Screen.CoinListScreen.rout){
                        composable(
                            route = Screen.CoinListScreen.rout
                        ){
                            CoinListScreen(navController)
                        }
                        composable(
                            route = Screen.CoinDetailScreen.rout + "/{coinId}"
                        ){
                            CoinDetailScreen()
                        }
                    }

                }

            }
        }
    }
}


