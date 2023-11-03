package com.example.app_kairos_projeto01


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.home_activity)

        var buttonCalendario: Button = findViewById(R.id.button3)
        var buttonPontos: Button = findViewById(R.id.button4)

        buttonCalendario.setOnClickListener {
            val intent = Intent(this, CalendarioActivity::class.java)
            startActivity(intent)
        }

        buttonPontos.setOnClickListener {
            val intent = Intent(this, PontosActivity::class.java)
            startActivity(intent)
        }

    }
}