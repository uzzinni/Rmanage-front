package com.example.community

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import com.example.community.databinding.ActivityChatItemPostBinding

class chat_item_post : AppCompatActivity() {
    private val viewBinding: ActivityChatItemPostBinding by lazy {
        ActivityChatItemPostBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)

        findViewById<ImageButton>(R.id.btn_post_close3).setOnClickListener {
            val intent = Intent(this, CommunityChat::class.java)
            startActivity(intent)
        }
    }
}