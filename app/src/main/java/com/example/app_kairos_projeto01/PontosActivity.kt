package com.example.app_kairos_projeto01


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class PontosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.pontos_activity)

        var buttonHome: Button = findViewById(R.id.button2)
        var buttonCalendario: Button = findViewById(R.id.button3)


        buttonHome.setOnClickListener {
            finish()
        }

//        buttonCalendario.setOnClickListener {
//            var intent: Intent = Intent(this,CalendarioActivity::class.java)
//            startActivity(intent)
//        }

    }
}