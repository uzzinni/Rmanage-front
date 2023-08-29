package com.example.mypage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat

class Membership : AppCompatActivity() {

    private lateinit var edit_email: EditText
    private lateinit var email_ok: Button
    private lateinit var resultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_membership)

        edit_email = findViewById(R.id.edit_email)
        email_ok = findViewById(R.id.email_ok)
        resultTextView = findViewById(R.id.resultTextView)

        val worker = findViewById<ImageView>(R.id.member_back)
        worker.setOnClickListener {
            val intent3 = Intent(this, Firstpage::class.java)
            startActivity(intent3)
        }

        email_ok.setOnClickListener {
            val email = edit_email.text.toString()

            if (isEmailValid(email)) {
                // 이메일 형식이 유효한 경우
                if (isEmailAlreadyRegistered(email)) {
                    // 이메일이 이미 가입되어 있는 경우
                    resultTextView.text = "이미 가입되어있는 이메일입니다."
                } else {
                    // 이메일이 가입되어 있지 않은 경우
                    val intent = Intent(this, Member_register::class.java)
                    startActivity(intent)
                }
                resultTextView.setTextColor(ContextCompat.getColor(this, R.color.red))
                resultTextView.visibility = View.VISIBLE
            } else {
                // 이메일 형식이 잘못된 경우
                resultTextView.text = "이메일을 형식에 맞게 입력해주세요."
                resultTextView.setTextColor(ContextCompat.getColor(this, R.color.red))
                resultTextView.visibility = View.VISIBLE
            }
        }
    }

    private fun isEmailValid(email: String): Boolean {
        // 이메일 유효성 체크 로직 구현
        // 여기서는 간단한 예시로 "@" 포함 여부만 확인합니다.
        return email.contains("@")
    }

    private fun isEmailAlreadyRegistered(email: String): Boolean {
        // 이메일이 이미 가입되어 있는지 체크하는 로직 구현
        // 여기서는 가입 여부를 무조건 false로 반환합니다.
        return false
    }
}
