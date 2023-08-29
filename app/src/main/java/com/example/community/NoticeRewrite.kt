package com.example.community

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.community.databinding.ActivityNoticeRewriteBinding

class NoticeRewrite : AppCompatActivity() {
    private  val viewBinding: ActivityNoticeRewriteBinding by lazy {
        ActivityNoticeRewriteBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)

        val isEditMode = intent.getBooleanExtra("isEditMode", false)
        val postTitle = intent.getStringExtra("postTitle")
        val postContent = intent.getStringExtra("postContent")

        val titleEditText = findViewById<EditText>(R.id.re_write_title)
        val contentEditText = findViewById<EditText>(R.id.re_write_content)

        if (isEditMode) {
            titleEditText.setText(postTitle)
            contentEditText.setText(postContent)
        }

        val btnSavePost = findViewById<Button>(R.id.btn_re_save_post)
        btnSavePost.setOnClickListener {
            val updatedTitle = titleEditText.text.toString()
            val updatedContent = contentEditText.text.toString()

            val intent = Intent()
            intent.putExtra("updatedTitle", updatedTitle)
            intent.putExtra("updatedContent", updatedContent)
            intent.putExtra("updatedPosition", intent.getIntExtra("position", -1)) // 해당 아이템의 위치 전달
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
}