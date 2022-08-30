package br.com.alura.technews.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager.VERTICAL
import br.com.alura.technews.R
import br.com.alura.technews.database.AppDatabase
import br.com.alura.technews.databinding.ActivityListaNoticiasBinding
import br.com.alura.technews.model.Noticia
import br.com.alura.technews.repository.NoticiaRepository
import br.com.alura.technews.ui.activity.extensions.mostraErro
import br.com.alura.technews.ui.recyclerview.adapter.ListaNoticiasAdapter
import br.com.alura.technews.ui.viewmodel.ListaNoticiasViewModel
import br.com.alura.technews.ui.viewmodel.factory.ListaNoticiasViewModelFactory


class ListaNoticiasActivity : AppCompatActivity() {

    private val adapter by lazy {
        ListaNoticiasAdapter(context = this)
    }
    private val viewModel by lazy {
        val repository = NoticiaRepository(AppDatabase.getInstance(this).noticiaDAO)
        val factory = ListaNoticiasViewModelFactory(repository)
        val provedor = ViewModelProviders.of(this, factory)
        provedor.get(ListaNoticiasViewModel::class.java)
    }
    private lateinit var binding: ActivityListaNoticiasBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_lista_noticias)
        title = TITULO_APPBAR
        configuraRecyclerView()
        configuraFabAdicionaNoticia()
        buscaNoticias()
    }

    private fun configuraFabAdicionaNoticia() {
        binding.fabSaveNews.setOnClickListener {
            abreFormularioModoCriacao()
        }
    }

    private fun configuraRecyclerView() {
        val divisor = DividerItemDecoration(this, VERTICAL)
        binding.recyclerviewListNews.addItemDecoration(divisor)
        binding.recyclerviewListNews.adapter = adapter
        configuraAdapter()
    }

    private fun configuraAdapter() {
        adapter.quandoItemClicado = this::abreVisualizadorNoticia
    }

    private fun buscaNoticias() {
        viewModel.buscaTodos().observe(this, Observer { resource ->
            resource.dado?.let { adapter.atualiza(it) }
            resource.erro?.let {
                mostraErro(MENSAGEM_FALHA_CARREGAR_NOTICIAS)
            }
        })
    }

    private fun abreFormularioModoCriacao() {
        val intent = Intent(this, FormularioNoticiaActivity::class.java)
        startActivity(intent)
    }

    private fun abreVisualizadorNoticia(it: Noticia) {
        val intent = Intent(this, VisualizaNoticiaActivity::class.java)
        intent.putExtra(NOTICIA_ID_CHAVE, it.id)
        startActivity(intent)
    }

    companion object {
        const val TITULO_APPBAR = "Notícias"
        const val MENSAGEM_FALHA_CARREGAR_NOTICIAS = "Não foi possível carregar as novas notícias"
    }

}