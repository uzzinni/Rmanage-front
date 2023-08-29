package com.example.mypage

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageBtn = findViewById<ImageButton>(R.id.setting)
        imageBtn.setOnClickListener{
            val intent = Intent(this,Setting::class.java)
            startActivity(intent)
        }

        if (savedInstanceState == null) {
            val bottomNaviFragment = BottomNavi()
            supportFragmentManager.beginTransaction()
                .add(R.id.bottom_navi, bottomNaviFragment)
                .commit()
        }
    }
}