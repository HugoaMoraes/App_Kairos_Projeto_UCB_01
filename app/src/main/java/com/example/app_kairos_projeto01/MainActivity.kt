package com.example.app_kairos_projeto01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var buttonProximo:Button = findViewById(R.id.button)

        buttonProximo.setOnClickListener {
            var intent: Intent = Intent(this,SecondActivity::class.java)
            startActivity(intent)
        }
    }
}