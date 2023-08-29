package com.example.mypage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView

class Setting : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)

        val idBtn = findViewById<TextView>(R.id.id)
        idBtn.setOnClickListener{
            val intent = Intent(this,ID::class.java)
            startActivity(intent)
        }
        val alarmBtn = findViewById<TextView>(R.id.id2)
        alarmBtn.setOnClickListener{
            val intent = Intent(this,Alarm::class.java)
            startActivity(intent)
        }
        val serviceBtn = findViewById<TextView>(R.id.id4)
        serviceBtn.setOnClickListener{
            val intent = Intent(this,Service_terms::class.java)
            startActivity(intent)
        }
        val privacyBtn = findViewById<TextView>(R.id.id5)
        privacyBtn.setOnClickListener{
            val intent = Intent(this,Privacy::class.java)
            startActivity(intent)
        }
    }
}