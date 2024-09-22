package com.example.pessoacrud.ui.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.pessoacrud.data.PessoaRepository
import com.example.pessoacrud.ui.PessoaScreen
import com.example.pessoacrud.ui.PessoaViewModel
import com.example.pessoacrud.ui.PessoaViewModelFactory

@Composable
fun PessoaNavGraph(navController: NavHostController, pessoaRepository: PessoaRepository) {
    val viewModel: PessoaViewModel = viewModel(factory = PessoaViewModelFactory(pessoaRepository))

    NavHost(navController, startDestination = "pessoaScreen") {
        composable("pessoaScreen") { PessoaScreen(viewModel) }
    }
}
