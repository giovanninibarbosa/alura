package br.com.alura.technews.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import br.com.alura.technews.model.Noticia
import br.com.alura.technews.repository.NoticiaRepository

class ListaNoticiasViewModel(
    private val repository: NoticiaRepository
) : ViewModel() {



    init {
        Log.d("ListaNoticiasViewModel", "creating")
    }

    override fun onCleared() {
        super.onCleared()
        Log.d("ListaNoticiasViewModel", "destroying")
    }

    fun buscaTodos(quandoSucesso: (novasNoticias: List<Noticia>) -> Unit,
                   quandoFalha: (erro: String?) -> Unit) {
            repository.buscaTodos(quandoSucesso,quandoFalha)
    }
}