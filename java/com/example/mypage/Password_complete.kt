package com.example.mypage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class Password_complete : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_password_complete)

        val back3 = findViewById<ImageView>(R.id.change_password_back3)
        back3.setOnClickListener{
            val intent = Intent(this,ID::class.java)
            startActivity(intent)
        }
    }
}