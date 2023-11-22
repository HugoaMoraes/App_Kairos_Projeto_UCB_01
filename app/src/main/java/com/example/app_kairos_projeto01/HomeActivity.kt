package com.example.app_kairos_projeto01


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
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
            startActivityForResult(intent, REQUEST_CODE_ADD_TASK) // Defina REQUEST_CODE_ADD_TASK como um valor constante
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

    companion object {
        private const val REQUEST_CODE_ADD_TASK = 1
    }
    fun atualizarRecyclerView() {
        val tarefaManager = TarefaManager(this)
        val tarefasAtualizadas = tarefaManager.lerTarefasDoSharedPreferences()
        (binding.RecyclerView.adapter as? Adapter)?.atualizarLista(tarefasAtualizadas)
    }

    override fun onResume() {
        super.onResume()
        initRecyclerView()
    }

    private fun initRecyclerView() {
        val tarefaManager = TarefaManager(this)
        val tarefasList = tarefaManager.lerTarefasDoSharedPreferences()
        val adapter = Adapter(tarefasList) { tarefa ->
            Toast.makeText(this, tarefa.nomeDaTarefa, Toast.LENGTH_SHORT).show()
            tarefaManager.salvarTarefa(tarefa) {
                atualizarRecyclerView()
            }
        }

        binding.RecyclerView.layoutManager = LinearLayoutManager(this)
        binding.RecyclerView.setHasFixedSize(true)
        binding.RecyclerView.adapter = adapter
    }

    private fun gerarDadosFalsos(): List<Tarefa> {
        val tarefasFalsas = mutableListOf<Tarefa>()
        for (i in 1..10) {
            tarefasFalsas.add(Tarefa("Tarefa $i", i * 10, false))
        }
        return tarefasFalsas
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_CODE_ADD_TASK) {
            if (resultCode == RESULT_OK) {
                atualizarRecyclerView()
            }
        }
    }

}