package com.example.mypage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class Registered_phone : AppCompatActivity() {
    private lateinit var dateTextView: TextView
    private lateinit var dateTextView2: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registered_phone)

        val back = findViewById<ImageView>(R.id.phone_register_back3)
        back.setOnClickListener {
            val intent2 = Intent(this, ID::class.java)
            startActivity(intent2)
        }

        dateTextView = findViewById(R.id.certificate)
        dateTextView2 = findViewById(R.id.phoneNum)
        val currentDate = intent.getStringExtra("current_date")
        val phoneNumber = intent.getStringExtra("phone_number")
        // 날짜 표시 업데이트
        updateDate(currentDate)
        updatePhoneNumber(phoneNumber)
        // ... (타이머 등의 기능 구현)
    }

    private fun updateDate(date: String?) {
        val updatedDate = "$date 인증됨"
        dateTextView.text = updatedDate
    }
    private fun updatePhoneNumber(phoneNumber: String?) {
        val updatedPhoneNumber = "$phoneNumber"
        dateTextView2.text = updatedPhoneNumber
    }
}