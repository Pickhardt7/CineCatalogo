package com.example.cinecatalogo.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CadastroScreen(
    onSalvar: (String, String, String, String) -> Unit,
    onCancelar: () -> Unit
) {
    var titulo by rememberSaveable { mutableStateOf("") }
    var genero by rememberSaveable { mutableStateOf("") }
    var ano by rememberSaveable { mutableStateOf("") }
    var sinopse by rememberSaveable { mutableStateOf("") }
    var erroAno by rememberSaveable { mutableStateOf(false) }

    Scaffold(
        topBar = { TopAppBar(title = { Text("Novo filme") }) }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            OutlinedTextField(
                value = titulo,
                onValueChange = { titulo = it },
                label = { Text("Título") },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = genero,
                onValueChange = { genero = it },
                label = { Text("Gênero") },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = ano,
                onValueChange = {
                    ano = it
                    erroAno = false
                },
                label = { Text("Ano") },
                isError = erroAno,
                supportingText = { if (erroAno) Text("Informe um ano válido") },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = sinopse,
                onValueChange = { sinopse = it },
                label = { Text("Sinopse") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Button(
                    onClick = {
                        val anoValido = ano.toIntOrNull() != null && ano.toInt() > 0
                        if (titulo.isNotBlank() && anoValido) {
                            onSalvar(titulo, genero, ano, sinopse)
                        } else {
                            erroAno = true
                        }
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Salvar")
                }
                OutlinedButton(onClick = onCancelar, modifier = Modifier.weight(1f)) {
                    Text("Cancelar")
                }
            }
        }
    }
}