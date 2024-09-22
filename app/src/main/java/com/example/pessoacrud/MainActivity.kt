package com.example.pessoacrud

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.pessoacrud.data.AppContainer
import com.example.pessoacrud.ui.navigation.PessoaNavGraph
import com.example.pessoacrud.ui.theme.PessoaCrudTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PessoaCrudTheme{

                val appContainer = AppContainer(applicationContext)
                val pessoaRepository = appContainer.pessoaRepository
                val navController = rememberNavController()
                PessoaNavGraph(navController = navController, pessoaRepository = pessoaRepository)
            }
        }
    }
}
