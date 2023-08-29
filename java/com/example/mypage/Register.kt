package com.example.mypage

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class Register : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val register = findViewById<Button>(R.id.register_btn)
        register.setOnClickListener {
            val intent = Intent(this, Registerphone2::class.java)
            startActivity(intent)
        }
        val registerback = findViewById<ImageView>(R.id.phone_register_back)
        registerback.setOnClickListener {
            val intent = Intent(this, ID::class.java)
            startActivity(intent)

        }
    }
}