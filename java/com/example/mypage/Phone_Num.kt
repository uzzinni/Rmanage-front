package com.example.mypage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class Phone_Num : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_num)

        val phoneba = findViewById<ImageView>(R.id.phone_back)
        phoneba.setOnClickListener{
            val intent = Intent(this,Setting::class.java)
            startActivity(intent)
        }
    }
}