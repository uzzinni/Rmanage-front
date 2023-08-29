package com.example.community

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.community.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val viewBinding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)


        findViewById<Button>(R.id.btn_notice).setOnClickListener {
            val intent = Intent(this, CommunityNotice::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.btn_insu).setOnClickListener {
            val intent = Intent(this, CommunityInsu::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.btn_chat).setOnClickListener {
            val intent = Intent(this, CommunityChat::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.btn_alchat).setOnClickListener {
            val intent = Intent(this, alchat_error::class.java)
            startActivity(intent)
        }

    }
}