package com.example.community

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.Menu
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.community.databinding.ActivityPostDetailBinding
import java.text.SimpleDateFormat
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.util.*

class NoticePostDetail : AppCompatActivity() {
    private val viewBinding: ActivityPostDetailBinding by lazy {
        ActivityPostDetailBinding.inflate(layoutInflater)
    }
    private val commentList: MutableList<CommentItem> = mutableListOf()
    private val postList: MutableList<NoticePost> = mutableListOf()
    private val noticeCommentAdapter: NoticeCommentAdapter = NoticeCommentAdapter(commentList)
    private val noticePostAdapter: NoticePostAdapter = NoticePostAdapter(postList)

    companion object {
        const val EDIT_POST_REQUEST_CODE = 123 // 정수값은 원하는 대로 지정 가능
        private const val DELETE_POST_REQUEST_CODE = 2 // 아무 숫자나 사용 가능한 정수 값
    }

    // 댓글 아이템 클래스
    data class CommentItem(
        val commenterName: String,
        val commentDate: String,
        val commentTime: String,
        val commentContent: String
    )

    private var itemId: Long = -1L

    private fun addComment(comment: CommentItem) {
        commentList.add(comment)
        noticeCommentAdapter.notifyDataSetChanged()

        val commentNumberTextView = findViewById<TextView>(R.id.notice_detail_comment_number)
        commentNumberTextView.text = commentList.size.toString()

        val intent = Intent()
        intent.putExtra("commentCount", commentList.size)
        setResult(Activity.RESULT_CANCELED, intent)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)

        findViewById<ImageButton>(R.id.btn_detail_back).setOnClickListener {
            val intent = Intent(this, CommunityNotice::class.java)
            startActivity(intent)
        }

        val btnNoticeDetailMenu = findViewById<ImageButton>(R.id.btn_notice_detail_menu)

        btnNoticeDetailMenu.setOnClickListener {
            val popupMenu = PopupMenu(this, it)
            popupMenu.inflate(R.menu.popup_menu)

            popupMenu.setOnMenuItemClickListener { menuItem ->
                when (menuItem.itemId) {
                    R.id.popup_edit -> {
                        val intent = Intent(this, NoticeRewrite::class.java)
                        intent.putExtra("isEditMode", true) // 수정 모드로 NoticeRewrite 열기
                        intent.putExtra(
                            "postTitle",
                            viewBinding.noticeDetailTitle.text.toString()
                        ) // 현재 게시물 제목 전달
                        intent.putExtra(
                            "postContent",
                            viewBinding.noticeDetailContent.text.toString()
                        ) // 현재 게시물 내용 전달
                        startActivityForResult(intent, EDIT_POST_REQUEST_CODE)
                        true
                    }
                    R.id.popup_delete -> {
                        val alertDialogBuilder = AlertDialog.Builder(this)
                        alertDialogBuilder.setMessage("삭제 하시겠습니까?")
                            .setPositiveButton("확인") { _, _ ->
                                val position = intent.getIntExtra("position", -1)
                                if (position != -1) {
                                    setResult(Activity.RESULT_OK, Intent().putExtra("position", position))
                                    noticePostAdapter.removeItem(position)
                                    finish()
                                }
                            }
                            .setNegativeButton("취소") { dialog, _ ->
                                dialog.dismiss()
                            }
                        val alertDialog = alertDialogBuilder.create()
                        alertDialog.show()

                        true
                    }
                    else -> false
                }
            }

            popupMenu.show()
        }

        val intent = intent
        val postTitle = intent.getStringExtra("postTitle")
        val postContent = intent.getStringExtra("postContent")
        viewBinding.noticeDetailTitle.text = postTitle
        viewBinding.noticeDetailContent.text = postContent

        val postAuthor = intent.getStringExtra("postId")
        val postDate = intent.getStringExtra("postDate")
        val postTime = intent.getStringExtra("postTime")

        findViewById<TextView>(R.id.notice_detail_title).text = postTitle
        findViewById<TextView>(R.id.notice_detail_content).text = postContent
        findViewById<TextView>(R.id.post_detail_date).text = postDate
        findViewById<TextView>(R.id.post_detail_time).text = postTime
        findViewById<TextView>(R.id.notice_detail_id).text = postAuthor

        val currentTime = Calendar.getInstance(TimeZone.getTimeZone("Asia/Seoul")).time
        val dateFormatter = SimpleDateFormat("yyyy.MM.dd", Locale("ko", "KR"))
        val formattedDate = dateFormatter.format(currentTime)
        findViewById<TextView>(R.id.post_detail_date).text = formattedDate

        val timeFormatter = SimpleDateFormat("HH:mm", Locale("ko", "KR"))
        val formattedTime = timeFormatter.format(currentTime)
        findViewById<TextView>(R.id.post_detail_time).text = formattedTime

        val writeCommentEditText = findViewById<EditText>(R.id.write_comment)
        val sendCommentButton = findViewById<ImageButton>(R.id.btn_notice_send_comment)

        sendCommentButton.setOnClickListener {
            val commentText = writeCommentEditText.text.toString()
        }

        val commentRecyclerView: RecyclerView = findViewById(R.id.notice_comments_recyclerview)
        commentRecyclerView.adapter = noticeCommentAdapter
        commentRecyclerView.layoutManager = LinearLayoutManager(this)

        findViewById<ImageButton>(R.id.btn_notice_send_comment).setOnClickListener {
            val commentContent = findViewById<EditText>(R.id.write_comment).text.toString()
            if (commentContent.isNotBlank()) {
                val currentTime = Calendar.getInstance(TimeZone.getTimeZone("Asia/Seoul")).time
                val dateFormatter = SimpleDateFormat("yyyy.MM.dd", Locale("ko", "KR"))
                val formattedDate = dateFormatter.format(currentTime)
                val timeFormatter = SimpleDateFormat("HH:mm", Locale("ko", "KR"))
                val formattedTime = timeFormatter.format(currentTime)

                val commenterName = "USER123" // 여기에 로그인된 사용자의 이름을 넣어야 함

                val newComment = CommentItem(
                    commenterName,
                    formattedDate,
                    formattedTime,
                    commentContent
                )

                addComment(newComment)

                findViewById<EditText>(R.id.write_comment).text.clear() // EditText 초기화
                val inputMethodManager =
                    getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                inputMethodManager.hideSoftInputFromWindow(currentFocus?.windowToken, 0) // 키보드 숨기기
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        Log.d("ActivityResult", "requestCode: $requestCode, resultCode: $resultCode")

        if (requestCode == EDIT_POST_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            val updatedTitle = data?.getStringExtra("updatedTitle")
            val updatedContent = data?.getStringExtra("updatedContent")
            val position = intent.getIntExtra("position", -1) // 추가: 수정 후의 위치 받기


            if (updatedTitle != null && updatedContent != null) {
                // 업데이트된 데이터를 사용하여 UI 업데이트
                findViewById<TextView>(R.id.notice_detail_title).text = updatedTitle
                findViewById<TextView>(R.id.notice_detail_content).text = updatedContent

            }
        } else if (requestCode == DELETE_POST_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            val position = data?.getIntExtra("position", -1)
            if (position != -1) {
                noticePostAdapter.removeItem(position!!)
                noticePostAdapter.notifyItemRemoved(position)
            }
        }
    }
}