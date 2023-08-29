package com.example.community

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.community.databinding.ActivityCommunityInsuBinding

class CommunityInsu : AppCompatActivity() {
    private val viewBinding: ActivityCommunityInsuBinding by lazy {
        ActivityCommunityInsuBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)


        findViewById<ImageButton>(R.id.btn_back2).setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        findViewById<Button>(R.id.btn_write2).setOnClickListener {
            val intent = Intent(this, insu_item_post::class.java)
            startActivity(intent)
        }
    }
}