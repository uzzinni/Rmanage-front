package com.example.mypage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat

class Nickname : AppCompatActivity() {
    private lateinit var editNickname: EditText
    private lateinit var resultTextView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nickname)

        editNickname = findViewById(R.id.edit_register)
        resultTextView = findViewById(R.id.resultTextView)

        val worker = findViewById<ImageView>(R.id.nick_back)
        worker.setOnClickListener {
            val intent3 = Intent(this, Member_password::class.java)
            startActivity(intent3)
        }

        editNickname.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // Do nothing
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // Check the condition and update the resultTextView accordingly
                val nickname = s.toString()
                if (nickname.length >= 3) {
                    resultTextView.text = "사용 가능한 닉네임입니다."
                    resultTextView.setTextColor(ContextCompat.getColor(this@Nickname, R.color.blue))
                    resultTextView.visibility = View.VISIBLE

                } else {
                    resultTextView.text = "이미 사용중인 닉네임입니다."
                    resultTextView.setTextColor(ContextCompat.getColor(this@Nickname, R.color.red))
                    resultTextView.visibility = View.VISIBLE
                }
            }

            override fun afterTextChanged(s: Editable?) {
                // Do nothing
            }
        })
    }
}