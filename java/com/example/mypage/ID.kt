package com.example.mypage

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class ID : AppCompatActivity() {
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_id)

        val email = findViewById<ImageView>(R.id.navigate_be)
        email.setOnClickListener{
            val intent = Intent(this,Email::class.java)
            startActivity(intent)
        }

        val phoneme = findViewById<ImageView>(R.id.navigate_be2)
        phoneme.setOnClickListener{
            val intent = Intent(this,Register::class.java)
            startActivity(intent)
        }
        val worker = findViewById<ImageView>(R.id.navigate_be3)
        worker.setOnClickListener{
            val intent = Intent(this,Worker_information::class.java)
            startActivity(intent)
        }
        val password = findViewById<ImageView>(R.id.navigate_be5)
        password.setOnClickListener{
            val intent = Intent(this,Changepassword::class.java)
            startActivity(intent)
        }
    }
}