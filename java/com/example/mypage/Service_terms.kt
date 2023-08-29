package com.example.mypage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class Service_terms : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service_terms)

        val back = findViewById<ImageView>(R.id.terms_back)
        back.setOnClickListener{
            val intent = Intent(this,Setting::class.java)
            startActivity(intent)
        }
    }
}