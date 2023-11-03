package com.example.app_kairos_projeto01

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class CalendarioActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.calendario_activity)

        var buttonHome: Button = findViewById(R.id.button2)
        var buttonPontos: Button = findViewById(R.id.button4)


        buttonPontos.setOnClickListener {
            var intent: Intent = Intent(this,PontosActivity::class.java)
            startActivity(intent)
        }

        buttonHome.setOnClickListener {
            finish()
        }

    }
}