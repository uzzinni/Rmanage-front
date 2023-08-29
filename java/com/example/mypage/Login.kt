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

class Login : AppCompatActivity() {

    private lateinit var edit_email: EditText
    private lateinit var edit_password: EditText
    private lateinit var password_ok2: Button
    private lateinit var resultTextView: TextView
    private lateinit var resultTextView2: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        edit_email = findViewById(R.id.edit_email)
        edit_password = findViewById(R.id.edit_password)
        password_ok2 = findViewById(R.id.password_ok2)
        resultTextView = findViewById(R.id.resultTextView)
        resultTextView2 = findViewById(R.id.resultTextView2)

        val worker = findViewById<ImageView>(R.id.login_back)
        worker.setOnClickListener {
            val intent3 = Intent(this, Firstpage::class.java)
            startActivity(intent3)
        }

        password_ok2.setOnClickListener {
            resultTextView.text = ""
            resultTextView2.text = ""
            resultTextView.visibility = View.INVISIBLE
            resultTextView2.visibility = View.INVISIBLE

            val email = edit_email.text.toString()
            val password = edit_password.text.toString()

            val loginResult = checkLoginCondition(email, password)
            when (loginResult) {
                LoginResult.SUCCESS -> {
                    // 로그인 성공 시 다음 페이지로 이동
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }
                LoginResult.INVALID_EMAIL -> {
                    // 이메일이 틀렸을 때 메시지 표시
                    resultTextView.text = "가입되어있지 않은 이메일입니다."
                    resultTextView.setTextColor(ContextCompat.getColor(this, R.color.red))
                    resultTextView.visibility = View.VISIBLE
                }
                LoginResult.INVALID_PASSWORD -> {
                    // 비밀번호가 틀렸을 때 메시지 표시
                    resultTextView2.text = "비밀번호가 틀렸습니다."
                    resultTextView2.setTextColor(ContextCompat.getColor(this, R.color.red))
                    resultTextView2.visibility = View.VISIBLE
                }
            }
        }
    }

    private fun checkLoginCondition(email: String, password: String): LoginResult {
        // 실제로 로그인 조건을 체크하고 그 결과를 반환하는 함수
        // 예를 들어, 올바른 이메일과 비밀번호인지 확인하여 LoginResult 반환
        if (email == "example@example.com") {
            if (password == "123456") {
                return LoginResult.SUCCESS
            } else {
                return LoginResult.INVALID_PASSWORD
            }
        } else {
            return LoginResult.INVALID_EMAIL
        }
    }
}

enum class LoginResult {
    SUCCESS,
    INVALID_EMAIL,
    INVALID_PASSWORD
}