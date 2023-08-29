package com.example.mypage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*
import kotlin.Number

class Number : AppCompatActivity() {
    private var totalSeconds = 5 * 60 // 5분을 초로 환산
    private lateinit var timerTextView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_number)

        val phoneNumber = intent.getStringExtra("phone_number")
        val currentDate = SimpleDateFormat("yyyy.MM.dd", Locale.getDefault()).format(Date())

        val intent2 = Intent(this, Registered_phone::class.java)
        intent2.putExtra("current_date", currentDate)
        intent2.putExtra("phone_number", phoneNumber) // 전화번호 데이터 다시 전달

        val worker = findViewById<ImageView>(R.id.Certification_register_back3)
        worker.setOnClickListener {
            val intent3 = Intent(this, ID::class.java)
            startActivity(intent3)
        }
        val ok = findViewById<Button>(R.id.Certification_btn_ok)
        ok.setOnClickListener {
            startActivity(intent2)
        }

        timerTextView = findViewById(R.id.timerTextView)
        // 초기 타이머 표시
        updateTimer()

        // 1초마다 타이머 업데이트
        val handler = Handler(Looper.getMainLooper())
        val runnable = object : Runnable {
            override fun run() {
                totalSeconds--
                if (totalSeconds >= 0) {
                    updateTimer()
                    handler.postDelayed(this, 1000)
                } else {
                    // 5분 경과 후 초기화
                    totalSeconds = 5 * 60
                    updateTimer()
                    handler.postDelayed(this, 1000)
                }
            }
        }
        handler.post(runnable)
    }

    private fun updateTimer() {
        val minutes = totalSeconds / 60
        val seconds = totalSeconds % 60
        val formattedTime = String.format("%01d:%02d", minutes, seconds)
        timerTextView.text = formattedTime
    }
}