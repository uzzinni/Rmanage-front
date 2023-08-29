package com.example.community

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import com.example.community.databinding.ActivityDocumentPlusBinding
import java.text.SimpleDateFormat
import java.util.*

class DocumentPlus : AppCompatActivity(), BottomSheetClickListener {
    private val viewBinding: ActivityDocumentPlusBinding by lazy {
        ActivityDocumentPlusBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)

        val bottomSheetButton = findViewById<ImageButton>(R.id.document_bs1)
        bottomSheetButton.setOnClickListener {
            // 바텀 시트 프래그먼트를 생성하고 보여줌
            val bottomSheetFragment = BottomSheetFragment()
            bottomSheetFragment.listener = this  // 리스너를 액티비티로 설정
            bottomSheetFragment.show(supportFragmentManager, bottomSheetFragment.tag)
        }

        val bottomSheetButton2 = findViewById<ImageButton>(R.id.document_bs2)
        bottomSheetButton2.setOnClickListener {
            // 바텀 시트 프래그먼트를 생성하고 보여줌
            val bottomSheetCalendar = BottomSheetCalendarFragment()
            bottomSheetCalendar.listener = this  // 리스너를 액티비티로 설정
            bottomSheetCalendar.show(supportFragmentManager, "BottomSheetCalendarFragment")
        }

        findViewById<ImageButton>(R.id.document_back4).setOnClickListener {
            val intent = Intent(this, DocumentDetail::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.btn_document_add2).setOnClickListener {
            val documentText1 = findViewById<TextView>(R.id.document_text1)
            val documentText2 = findViewById<TextView>(R.id.document_text2)

            val documentData = DocumentData(
                1,
                documentText1.text.toString(),
                documentText2.text.toString(),
                "your_image_url_here"
            )

            val resultintent = Intent()
            resultintent.putExtra("documentData", documentData)
            setResult(Activity.RESULT_OK, resultintent)
            finish()

        }
    }

    override fun onTextViewClicked(text: String) {
        val documentPlusFileTextView = findViewById<TextView>(R.id.document_text1)
        documentPlusFileTextView.text = text
    }

    override fun onDateSelected(date: Long) {
        val documentPlusCalendar = findViewById<TextView>(R.id.document_text2)
        val selectedDateText =
            SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date(date))
        documentPlusCalendar.text = selectedDateText

    }
}