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

class Findpassword : AppCompatActivity() {
    private lateinit var edit_email: EditText
    private lateinit var email_ok: Button
    private lateinit var resultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_findpassword)

        edit_email = findViewById(R.id.edit_email)
        email_ok = findViewById(R.id.email_ok)
        resultTextView = findViewById(R.id.resultTextView)

        val worker = findViewById<ImageView>(R.id.find_back)
        worker.setOnClickListener {
            val intent3 = Intent(this, Firstpage::class.java)
            startActivity(intent3)
        }

        email_ok.setOnClickListener {
            val email = edit_email.text.toString()

            // 실제로 가입된 이메일인지 확인하는 로직을 수행하고 그 결과를 받아옵니다.
            val isRegisteredEmail = checkIfEmailIsRegistered(email)

            if (isRegisteredEmail) {
                // 가입된 이메일인 경우 텍스트를 초기화하고 뷰를 숨깁니다.
                resultTextView.text = ""
                resultTextView.visibility = View.INVISIBLE
                val intent = Intent(this, Emailsend::class.java)
                startActivity(intent)
            } else {
                // 가입되지 않은 이메일인 경우 빨간 글씨로 텍스트를 띄웁니다.
                resultTextView.text = "가입되어있지 않은 이메일입니다."
                resultTextView.setTextColor(ContextCompat.getColor(this, R.color.red))
                resultTextView.visibility = View.VISIBLE
            }
        }
    }

    // 이메일이 가입되었는지 확인하는 함수 (가상의 함수로 가정)
    private fun checkIfEmailIsRegistered(email: String): Boolean {
        // 이 부분을 실제로 가입된 이메일 목록과 비교하는 로직으로 대체해야 합니다.
        // 가입되면 true, 가입되지 않았으면 false를 반환하도록 구현합니다.
        val registeredEmails = listOf("example@example.com", "user@example.com")
        return email in registeredEmails
    }
}