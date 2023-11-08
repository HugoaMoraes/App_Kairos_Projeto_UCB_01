package com.example.app_kairos_projeto01


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.app_kairos_projeto01.databinding.HomeActivityBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding:HomeActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = HomeActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var buttonCalendario: Button = findViewById(R.id.button3)
        var buttonPontos: Button = findViewById(R.id.button4)
        var buttonNovaTarefa: Button = findViewById(R.id.button)

        buttonCalendario.setOnClickListener {
            val intent = Intent(this, CalendarioActivity::class.java)
            startActivity(intent)
        }
        buttonNovaTarefa.setOnClickListener {
            val intent = Intent(this, CalendarioActivity::class.java)
            startActivity(intent)
        }

        buttonPontos.setOnClickListener {
            val intent = Intent(this, PontosActivity::class.java)
            startActivity(intent)
        }
        initRecyclerView()
    }
    private fun initRecyclerView(){
        binding.RecyclerView.layoutManager = LinearLayoutManager(this)
        binding.RecyclerView.setHasFixedSize(true)
        binding.RecyclerView.adapter = Adpter(getList())
    }

    private fun getList() = listOf(
        "giovani",
        "giovani",
        "giovani",
        "giovani",
        "giovani",
        "giovani",
        "giovani",
        "giovani",
        "giovani",
        "giovani",
        "giovani",
        "giovani",
        "giovani",
        "giovani",
        "giovani"
    )

}