package com.example.community

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import com.example.community.databinding.ActivityCommunityChatBinding

class CommunityChat : AppCompatActivity() {
    private val viewBinding: ActivityCommunityChatBinding by lazy {
        ActivityCommunityChatBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)

        findViewById<ImageButton>(R.id.btn_back3).setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        findViewById<Button>(R.id.btn_write3).setOnClickListener {
            val intent = Intent(this, chat_item_post::class.java)
            startActivity(intent)
        }
    }
}