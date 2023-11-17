package com.example.app_kairos_projeto01


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.app_kairos_projeto01.databinding.HomeActivityBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding:HomeActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = HomeActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var buttonPontos: Button = findViewById(R.id.button4)
        var buttonNovaTarefa: Button = findViewById(R.id.button)
        var buttonConfig: ImageButton = findViewById(R.id.button5)

        buttonNovaTarefa.setOnClickListener {
            val intent = Intent(this, CalendarioActivity::class.java)
            startActivity(intent)
        }

        buttonConfig.setOnClickListener {
            val intent = Intent(this, ConfigActivity::class.java)
            startActivity(intent)
        }

        buttonPontos.setOnClickListener {
            val intent = Intent(this, PontosActivity::class.java)
            startActivity(intent)
        }
        initRecyclerView()
    }
    private fun initRecyclerView() {
        val namesList = getList()
        // Inicializar a lista de estados do CheckBox com valores 'false'
        val checkBoxStates = MutableList(namesList.size) { false }

        binding.RecyclerView.layoutManager = LinearLayoutManager(this)
        binding.RecyclerView.setHasFixedSize(true)
        // Passar ambas as listas para o Adapter
        binding.RecyclerView.adapter = Adpter(namesList, checkBoxStates){ tarefa ->
            Toast.makeText(this, tarefa, Toast.LENGTH_SHORT).show()
        }
    }

    private fun getList() = listOf(
        "Comprar leite",
        "Ir à academia",
        "Estudar Kotlin",
        "Marcar consulta médica",
        "Pagar contas",
        "Ler um livro",
        "Assistir a uma aula online",
        "Limpar o quarto",
        "Preparar o almoço",
        "Lavar o carro",
        "Praticar meditação",
        "Fazer compras no supermercado",
        "Passear com o cachorro",
        "Organizar documentos",
        "Ligar para um amigo"
    )


}