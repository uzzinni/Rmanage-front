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

class Member_register : AppCompatActivity() {
    private var totalSeconds = 5 * 60 // 5분을 초로 환산
    private lateinit var timerTextView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_member_register)

        timerTextView = findViewById(R.id.timerTextView)
        updateTimer()

        val ok = findViewById<Button>(R.id.register_ok)
        ok.setOnClickListener{
            val intent = Intent(this,Member_terms::class.java)
            startActivity(intent)
        }

        val worker = findViewById<ImageView>(R.id.member_back)
        worker.setOnClickListener {
            val intent3 = Intent(this, Membership::class.java)
            startActivity(intent3)
        }

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
