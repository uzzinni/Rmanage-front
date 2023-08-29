package com.example.mypage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class Worker_information : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_worker_information)

        val worker = findViewById<Button>(R.id.btn_add)
        worker.setOnClickListener{
            val intent = Intent(this,Email::class.java)
            startActivity(intent)
        }
    }
}