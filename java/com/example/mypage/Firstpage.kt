package com.example.mypage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class Firstpage : AppCompatActivity() {

    private lateinit var login: Button
    private lateinit var member: Button
    private lateinit var findpassword: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_firstpage)

        login = findViewById(R.id.firstpage_login)
        member = findViewById(R.id.firstpage_member)
        findpassword = findViewById(R.id.first_find)

        login.setOnClickListener {
            val intent = Intent(this,Login::class.java)
            startActivity(intent)
        }
        member.setOnClickListener {
            val intent2 = Intent(this,Membership::class.java)
            startActivity(intent2)
        }
        findpassword.setOnClickListener {
            val intent3 = Intent(this,Findpassword::class.java)
            startActivity(intent3)
        }
    }
}