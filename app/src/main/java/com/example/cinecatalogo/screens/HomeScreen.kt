package com.example.cinecatalogo.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.cinecatalogo.model.Filme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    filmes: List<Filme>,
    onNovoFilmeClick: () -> Unit,
    onSobreClick: () -> Unit,
    onDetalhesClick: (Int) -> Unit
) {
    Scaffold(
        topBar = { TopAppBar(title = { Text("CineCatálogo") }) }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            Text(text = "${filmes.size} filmes cadastrados", style = MaterialTheme.typography.bodyLarge)
            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Button(onClick = onNovoFilmeClick, modifier = Modifier.weight(1f)) {
                    Text("Novo filme")
                }
                Button(onClick = onSobreClick, modifier = Modifier.weight(1f)) {
                    Text("Sobre")
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                items(filmes) { filme ->
                    Card(modifier = Modifier.fillMaxWidth()) {
                        Column(modifier = Modifier.padding(20.dp)) {
                            Text(text = filme.titulo, style = MaterialTheme.typography.titleMedium)
                            Text(text = "${filme.genero} • ${filme.ano}", style = MaterialTheme.typography.bodyMedium)
                            Spacer(modifier = Modifier.height(8.dp))
                            TextButton(
                                onClick = { onDetalhesClick(filme.id) },
                                modifier = Modifier.align(Alignment.Start)
                            ) {
                                Text("Detalhes")
                            }
                        }
                    }
                }
            }
        }
    }
}