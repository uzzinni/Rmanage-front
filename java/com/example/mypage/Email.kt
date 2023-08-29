package com.example.mypage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class Email : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_email)

        val emailba = findViewById<ImageView>(R.id.email_back)
        emailba.setOnClickListener{
            val intent = Intent(this,ID::class.java)
            startActivity(intent)
        }
    }
}