package com.example.cinecatalogo.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.cinecatalogo.model.Filme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetalhesScreen(filme: Filme?, onVoltar: () -> Unit) {
    Scaffold(
        topBar = { TopAppBar(title = { Text("Detalhes") }) }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            if (filme != null) {
                Text(text = filme.titulo, style = MaterialTheme.typography.headlineMedium)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "Gênero: ${filme.genero}", style = MaterialTheme.typography.bodyLarge)
                Text(text = "Ano: ${filme.ano}", style = MaterialTheme.typography.bodyLarge)
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = "Sinopse:", style = MaterialTheme.typography.titleMedium)
                Text(text = filme.sinopse, style = MaterialTheme.typography.bodyMedium)
            } else {
                Text(text = "Filme não encontrado.", color = MaterialTheme.colorScheme.error)
            }

            Spacer(modifier = Modifier.weight(1f))
            Button(onClick = onVoltar, modifier = Modifier.fillMaxWidth()) {
                Text("Voltar")
            }
        }
    }
}

