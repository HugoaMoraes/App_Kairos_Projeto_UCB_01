package com.example.app_kairos_projeto01


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.app_kairos_projeto01.databinding.CalendarioActivityBinding
import com.example.app_kairos_projeto01.databinding.HomeActivityBinding
import com.example.app_kairos_projeto01.databinding.PontosActivityBinding

class PontosActivity : AppCompatActivity() {

    private lateinit var binding: PontosActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = PontosActivityBinding.inflate(layoutInflater)
        setContentView(R.layout.pontos_activity)

        var buttonHome: Button = findViewById(R.id.button2)
        var buttonConfig: ImageButton = findViewById(R.id.button5)

        buttonConfig.setOnClickListener {
            val intent = Intent(this, ConfigActivity::class.java)
            startActivity(intent)
        }

        buttonHome.setOnClickListener {
            finish()
        }


        initPontos()
    }

    private fun initPontos() {
        val tarefaManager = TarefaManager(this)
        val tarefasList = tarefaManager.lerTarefasDoSharedPreferences()

        // Filtrar as tarefas em que isCompleted é igual a true
        val tarefasCompletas = tarefasList.filter { it.isCompleted }

        // Calcular a soma dos pontos das tarefas completas
        val pontosTotais = tarefasCompletas.sumBy { it.pontos }

        // Mostrar o resultado na view
        binding.pontos.text = pontosTotais.toString()
    }
}