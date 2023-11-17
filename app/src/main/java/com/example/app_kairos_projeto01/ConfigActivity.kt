package com.example.app_kairos_projeto01

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class ConfigActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.config_activity)

        var buttonHome: Button = findViewById(R.id.button2)

        buttonHome.setOnClickListener {
            finish()
        }

    }
}