package com.example.cinecatalogo.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.cinecatalogo.data.FilmeViewModel
import com.example.cinecatalogo.screens.CadastroScreen
import com.example.cinecatalogo.screens.DetalhesScreen
import com.example.cinecatalogo.screens.HomeScreen
import com.example.cinecatalogo.screens.SobreScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val viewModel: FilmeViewModel = viewModel()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(
                filmes = viewModel.filmes,
                onNovoFilmeClick = { navController.navigate("cadastro") },
                onSobreClick = { navController.navigate("sobre") },
                onDetalhesClick = { id -> navController.navigate("detalhes/$id") }
            )
        }

        composable("cadastro") {

            CadastroScreen(
                onSalvar = { titulo, genero, ano, sinopse ->
                    viewModel.adicionarFilme(titulo, genero, ano, sinopse)
                    navController.popBackStack()
                },
                onCancelar = { navController.popBackStack() }
            )
        }

        composable(
            route = "detalhes/{id}",
            arguments = listOf(navArgument("id") { type = NavType.IntType })
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getInt("id")
            val filme = id?.let { viewModel.buscarFilmePorId(it) }
            DetalhesScreen(
                filme = filme,
                onVoltar = { navController.popBackStack() }
            )
        }

        composable("sobre") {
            SobreScreen(
                onVoltar = { navController.popBackStack() }
            )
        }
    }
}