package com.example.cinecatalogo.screens

import android.content.Intent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SobreScreen(onVoltar: () -> Unit) {
    val context = LocalContext.current

    Scaffold(
        topBar = { TopAppBar(title = { Text("Sobre") }) }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            Text(text = "CineCatálogo", style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Catálogo para organizar seus filmes.", style = MaterialTheme.typography.bodyLarge)
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Como usar:", style = MaterialTheme.typography.titleMedium)
            Text(text = "Toque em 'Novo filme' para cadastrar e em 'Detalhes' para consultar.", style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Desenvolvedores:", style = MaterialTheme.typography.titleMedium)
            Text(text = "Eduardo Gomes de Lima\nPetherson R. P. do Sacramento", style = MaterialTheme.typography.bodyMedium)

            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = {
                    val textoCompartilhar = "Conheça o app CineCatálogo! Organize seus filmes favoritos."
                    val intent = Intent(Intent.ACTION_SEND).apply {
                        type = "text/plain"
                        putExtra(Intent.EXTRA_TEXT, textoCompartilhar)
                    }
                    try {
                        context.startActivity(Intent.createChooser(intent, "Compartilhar aplicativo"))
                    } catch (e: Exception) {
                        // Trata caso não haja app compatível
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Compartilhar aplicativo")
            }

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedButton(onClick = onVoltar, modifier = Modifier.fillMaxWidth()) {
                Text("Voltar")
            }
        }
    }
}

