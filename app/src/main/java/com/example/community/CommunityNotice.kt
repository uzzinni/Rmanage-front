package com.example.community

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.community.databinding.ActivityCommunityNoticeBinding
import kotlin.random.Random

class CommunityNotice : AppCompatActivity() {
    private val viewBinding: ActivityCommunityNoticeBinding by lazy {
        ActivityCommunityNoticeBinding.inflate(layoutInflater)
    }
    fun addNotice(noticePost: NoticePost) {
        noticePostList.add(0, noticePost)
        noticePostAdapter.notifyItemInserted(0)
    }

    private lateinit var noticePostList: MutableList<NoticePost>
    private lateinit var noticePostAdapter: NoticePostAdapter
    private lateinit var recyclerView: RecyclerView

    private fun generateUniqueId(): Long {
        return Random.nextLong()
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)

        // noticePost 초기화
        noticePostList = mutableListOf()

        // RecyclerView 초기화
        recyclerView = findViewById(R.id.notice_recyclerview)
        noticePostAdapter = NoticePostAdapter(noticePostList)
        recyclerView.adapter = noticePostAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)


        findViewById<ImageButton>(R.id.btn_back).setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.btn_write).setOnClickListener {
            val intent = Intent(this, notice_item_post::class.java)
            val uniqueId = generateUniqueId()
            intent.putExtra("postId", uniqueId)
            startActivityForResult(intent, REQUEST_CODE_WRITE_POST)
        }
    }


    // startActivityForResult의 결과를 받는 메서드
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_CODE_WRITE_POST && resultCode == Activity.RESULT_OK && data != null) {
            val title = data.getStringExtra("title")
            val content = data.getStringExtra("content")
            val postDate = data.getStringExtra("postDate")
            val authorName = data.getStringExtra("authorName")
            val postTime = data.getStringExtra("postTime") ?: ""
            val postId = data.getLongExtra("postId", -1L)

            val updatedTitle = data.getStringExtra("updatedTitle")
            val updatedContent = data.getStringExtra("updatedContent")



            if (!title.isNullOrBlank() && !content.isNullOrBlank() && !postDate.isNullOrBlank() && !authorName.isNullOrBlank()) {
                val newNoticePost = NoticePost(postDate, authorName, title, 0, content, postTime, postId)
                addNotice(newNoticePost)
            }

        } else if (requestCode == REQUEST_CODE_WRITE_POST && resultCode == Activity.RESULT_OK) {
            val position = data?.getIntExtra("position", -1)
            if (position != -1) {
                noticePostAdapter.removeItem(position!!)
                noticePostAdapter.notifyDataSetChanged()
            }
        }
    }

    companion object {
        private const val REQUEST_CODE_WRITE_POST = 100
    }

}