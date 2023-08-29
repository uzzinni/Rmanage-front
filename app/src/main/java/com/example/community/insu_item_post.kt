package com.example.community

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import com.example.community.databinding.ActivityInsuItemPostBinding
import java.text.SimpleDateFormat
import java.util.*

class insu_item_post : AppCompatActivity() {
    private val viewBinding: ActivityInsuItemPostBinding by lazy {
        ActivityInsuItemPostBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)

        findViewById<ImageButton>(R.id.btn_post_close2).setOnClickListener {
            val intent = Intent(this, CommunityInsu::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.btn_save_post2).setOnClickListener {
            val title = findViewById<EditText>(R.id.write_title2).text.toString()
            val content = findViewById<EditText>(R.id.write_content2).text.toString()

        }
    }
}