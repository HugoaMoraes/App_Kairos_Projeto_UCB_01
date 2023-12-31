package com.example.app_kairos_projeto01

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class ThirdActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.third_activity)

        var buttonVoltar: Button = findViewById(R.id.button2)
        var buttonLogar: Button = findViewById(R.id.button)

        buttonLogar.setOnClickListener {
            var intent: Intent = Intent(this,HomeActivity::class.java)
            startActivity(intent)
        }

        buttonVoltar.setOnClickListener {
            finish()
        }
    }
}