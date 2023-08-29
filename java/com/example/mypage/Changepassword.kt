package com.example.mypage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class Changepassword : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_changepassword)

        val worker = findViewById<Button>(R.id.password_ok)
        worker.setOnClickListener{
            val intent = Intent(this,Passwordok::class.java)
            startActivity(intent)
        }
        val back = findViewById<ImageView>(R.id.change_password_back)
        back.setOnClickListener{
            val intent = Intent(this,ID::class.java)
            startActivity(intent)
        }
    }
}