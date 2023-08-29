package com.example.community

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import com.example.community.R
import com.example.community.databinding.ActivityNoticeItemPostBinding
import java.text.SimpleDateFormat
import java.util.*

class notice_item_post : AppCompatActivity() {
    private val viewBinding: ActivityNoticeItemPostBinding by lazy {
        ActivityNoticeItemPostBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)

        findViewById<ImageButton>(R.id.btn_post_close).setOnClickListener {
            val intent = Intent(this, CommunityNotice::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.btn_save_post).setOnClickListener {
            val title = findViewById<EditText>(R.id.write_title).text.toString()
            val content = findViewById<EditText>(R.id.write_content).text.toString()

            if (!title.isNullOrBlank() && !content.isNullOrBlank()) {
                // 현재 시간을 글쓴 날짜로 자동으로 입력합니다.
                val dateFormat = SimpleDateFormat("yyyy.MM.dd", Locale.getDefault())
                dateFormat.timeZone = TimeZone.getTimeZone("Asia/Seoul")
                val postDate = dateFormat.format(Date())

                val koreanTimeFormat = SimpleDateFormat("yyyy.MM.dd", Locale.KOREA)
                val koreanPostDate = koreanTimeFormat.format(dateFormat.parse(postDate))

                // 로그인 정보를 통해 작성자 이름을 저장합니다.
                // 여기서는 임의의 사용자 이름을 사용합니다. 로그인 시 실제 사용자 이름을 설정하세요.
                val authorName = "USER"


                val resultIntent = Intent()
                resultIntent.putExtra("title", title)
                resultIntent.putExtra("content", content)
                resultIntent.putExtra("authorName", authorName)
                resultIntent.putExtra("postDate", koreanPostDate)
                resultIntent.putExtra("postTime", "00:00") // 작성 시간은 현재 미포함
                setResult(Activity.RESULT_OK, resultIntent)

                finish()
            }
        }
    }
}