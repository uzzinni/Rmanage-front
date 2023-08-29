package com.example.mypage

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.widget.*

@Suppress("NAME_SHADOWING")
class Passwordok : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_passwordok)

        val back2 = findViewById<ImageView>(R.id.change_password_back2)
        back2.setOnClickListener{
            val intent = Intent(this,ID::class.java)
            startActivity(intent)
        }


        val textView = findViewById<TextView>(R.id.change_password_box2)
        val fullText = getString(R.string.emailok) // 이 부분은 strings.xml에서 정의한 문자열 리소스를 가져와 사용합니다.

        val startIndex = fullText.indexOf("이메일이 확인") // 변경하고자 하는 텍스트의 시작 위치
        val endIndex = startIndex + "이메일이 확인".length // 변경하고자 하는 텍스트의 끝 위치

        val spannable = SpannableString(fullText)
        spannable.setSpan(ForegroundColorSpan(Color.RED), startIndex, endIndex, SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE)

        textView.text = spannable

        val password1EditText = findViewById<EditText>(R.id.password_wc)
        val password2EditText = findViewById<EditText>(R.id.password_1)
        val okButton = findViewById<Button>(R.id.password_ok2)

        okButton.setOnClickListener {
            val password1 = password1EditText.text.toString()
            val password2 = password2EditText.text.toString()

            if (password1.isEmpty() || password2.isEmpty()) {
                // 비밀번호 입력란이 비어있는 경우 토스트 메시지 출력
                val toast = Toast.makeText(this, "비밀번호를 입력해주세요.", Toast.LENGTH_SHORT)
                val textView = toast.view?.findViewById(android.R.id.message) as? TextView
                textView?.apply {
                    textSize = 20f // 크기 변경
                    setTextColor(Color.BLUE) // 색상 변경
                }
                toast.show()
            } else if (password1 == password2) {
                val intent = Intent(this, Password_complete::class.java)
                startActivity(intent)
            }else{
                val toast = Toast.makeText(this, "비밀번호가 같지 않습니다.", Toast.LENGTH_SHORT)
                val textView = toast.view?.findViewById(android.R.id.message) as? TextView
                textView?.apply {
                    textSize = 20f // 크기 변경
                    setTextColor(Color.BLUE) // 색상 변경
                }
                toast.show()
            }
        }
    }
}