package com.example.cinecatalogo.data

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.cinecatalogo.model.Filme


class FilmeViewModel : ViewModel() {
    private var proximoID = 4

    val filmes = mutableStateListOf(
        Filme(1, "Interestelar", "Ficção científica", "2014", "Astronautas viajam por um buraco de minhoca."),
        Filme(2, "Cidade de Deus", "Drama", "2002", "A vida de jovens na favela."),
        Filme(3, "O Auto da Compadecida", "Comédia", "2000", "As aventuras de João Grilo e Chicó.")
    )

    fun adicionarFilme(titulo: String, genero: String, ano: String, sinopse: String) {
        val novoFilme = Filme(
            id = proximoID++,
            titulo = titulo,
            genero = genero,
            ano = ano,
            sinopse = sinopse
        )
        filmes.add(novoFilme)
    }

    fun buscarFilmePorId(id: Int): Filme? {
        return filmes.find { it.id == id }
    }
}