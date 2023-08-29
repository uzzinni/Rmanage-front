package com.example.mypage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView

class Registerphone2 : AppCompatActivity() {

    private lateinit var edit: EditText
    private lateinit var ok: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registerphone2)

        val worker = findViewById<ImageView>(R.id.phone_register_back2)
        worker.setOnClickListener {
            val intent = Intent(this, ID::class.java)
            startActivity(intent)
        }

        edit = findViewById(R.id.edit_phone2)
        ok = findViewById(R.id.register_btn_ok)

        edit.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // Nothing to do before text changed
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // Nothing to do when text is changing
            }

            override fun afterTextChanged(s: Editable?) {
                val phoneNumber = s.toString().replace("\\D".toRegex(), "") // 숫자만 추출
                val formatted = when {
                    phoneNumber.length <= 3 -> phoneNumber
                    phoneNumber.length <= 7 -> "010-${phoneNumber.substring(3)}"
                    else -> "010-${phoneNumber.substring(3, 7)}-${phoneNumber.substring(7)}"
                }
                edit.removeTextChangedListener(this) // Remove the listener to prevent recursive changes
                edit.setText(formatted)
                edit.setSelection(formatted.length) // Set cursor position at the end
                edit.addTextChangedListener(this) // Re-add the listener
            }
        })

        ok.setOnClickListener {
            val phoneNumber = edit.text.toString()
            navigateToNumberActivity(phoneNumber)
        }
    }

    private fun navigateToNumberActivity(phoneNumber: String) {
        val intent = Intent(this, Number::class.java)
        intent.putExtra("phone_number", phoneNumber) // 전화번호 데이터 전달
        startActivity(intent)
    }
}
