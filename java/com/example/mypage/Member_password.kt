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

class Member_password : AppCompatActivity() {
    private lateinit var edit_email: EditText
    private lateinit var edit_email2: EditText
    private lateinit var email_ok: Button
    private lateinit var resultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_member_password)

        edit_email = findViewById(R.id.edit_register)
        edit_email2 = findViewById(R.id.edit_register2)
        email_ok = findViewById(R.id.email_ok2)
        resultTextView = findViewById(R.id.resultTextView)

        val worker = findViewById<ImageView>(R.id.password_back)
        worker.setOnClickListener {
            val intent3 = Intent(this, Member_terms::class.java)
            startActivity(intent3)
        }

        email_ok.setOnClickListener {
            val password1 = edit_email.text.toString()
            val password2 = edit_email2.text.toString()

            if (password1 == password2) {
                // Passwords match
                val intent = Intent(this, Nickname::class.java)
                startActivity(intent)
            } else {
                // Passwords do not match
                resultTextView.text = "비밀번호를 다시 입력해주세요."
                resultTextView.setTextColor(ContextCompat.getColor(this, R.color.red))
                resultTextView.visibility = View.VISIBLE
            }
        }
    }
}