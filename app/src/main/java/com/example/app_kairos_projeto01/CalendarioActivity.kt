package com.example.app_kairos_projeto01

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.app_kairos_projeto01.databinding.CalendarioActivityBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class CalendarioActivity : AppCompatActivity() {

    private lateinit var binding: CalendarioActivityBinding

    private lateinit var tarefaMenager: TarefaManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = CalendarioActivityBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val buttonHome: Button = findViewById(R.id.button2)
        val buttonConfig: ImageButton = findViewById(R.id.button5)

        buttonConfig.setOnClickListener {
            val intent = Intent(this, ConfigActivity::class.java)
            startActivity(intent)
        }

        buttonHome.setOnClickListener {
            finish()
        }

        tarefaMenager = TarefaManager(this)

        initListeners()
    }

    private fun initListeners () {
        binding.button.setOnClickListener{adicionarTarefa()}
    }

    private fun adicionarTarefa() {
        val name = binding.pegaNomeTarefa.text.toString()
        val selectedRadioButtonId = binding.radioGroup.checkedRadioButtonId

        if (selectedRadioButtonId == -1) {
            Toast.makeText(this, "Por favor, selecione uma opção de pontos", Toast.LENGTH_SHORT).show()
            return
        }

        val radioButton = findViewById<RadioButton>(selectedRadioButtonId)
        val pontos = radioButton.text.toString().toIntOrNull() ?: 0

        val novaTarefa = Tarefa(name, pontos, false)

        val sharedPref = this.getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        val gson = Gson()

        // Recuperar o array de tarefas existente, se houver
        val tarefasJson = sharedPref.getString("tarefas", null)
        val type = object : TypeToken<List<Tarefa>>() {}.type
        val tarefas: MutableList<Tarefa> = gson.fromJson(tarefasJson, type) ?: mutableListOf()

        // Adicionar a nova tarefa ao array
        tarefas.add(novaTarefa)

        // Salvar o array atualizado de volta ao SharedPreferences
        editor.putString("tarefas", gson.toJson(tarefas))
        editor.apply()

        Toast.makeText(this, "Tarefa Salva: $name", Toast.LENGTH_SHORT).show()

        setResult(RESULT_OK)
        finish()
    }



}