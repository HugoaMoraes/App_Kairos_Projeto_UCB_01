package com.example.app_kairos_projeto01

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class CalendarioActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.calendario_activity)

        var buttonHome: Button = findViewById(R.id.button2)
        var buttonConfig: ImageButton = findViewById(R.id.button5)

        buttonConfig.setOnClickListener {
            val intent = Intent(this, ConfigActivity::class.java)
            startActivity(intent)
        }

        buttonHome.setOnClickListener {
            finish()
        }

    }
}