package com.example.mypage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView

class Member_terms : AppCompatActivity() {

    private lateinit var imageButton: ImageButton
    private lateinit var imageButton2: ImageButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_member_terms)

        val email = findViewById<Button>(R.id.email_ok2)
        email.setOnClickListener{
            val intent = Intent(this,Member_password::class.java)
            startActivity(intent)
        }

        val worker = findViewById<ImageView>(R.id.terms_back)
        worker.setOnClickListener {
            val intent3 = Intent(this, Member_register::class.java)
            startActivity(intent3)
        }

        imageButton = findViewById(R.id.terms_ch)
        imageButton2 = findViewById(R.id.terms_ch2)
        // Set initial image resource
        imageButton.setImageResource(R.drawable.baseline_check_circle_24)
        imageButton2.setImageResource(R.drawable.baseline_check_circle_24)// Change to your initial image resource

        // Set a click listener on the image button
        imageButton.setOnClickListener {
            toggleImage(imageButton)
        }

        imageButton2.setOnClickListener {
            toggleImage(imageButton2)
        }
    }

    private fun toggleImage(button: ImageButton) {
        val isChecked = button.tag as? Boolean ?: false

        if (isChecked) {
            button.setImageResource(R.drawable.baseline_check_circle_24)
        } else {
            button.setImageResource(R.drawable.baseline_check_24)
        }

        button.tag = !isChecked
    }
}