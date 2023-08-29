package com.example.mypage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*

class DocumentPlus : AppCompatActivity(), BottomSheetClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_document_plus)


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
            bottomSheetCalendar.show(supportFragmentManager,  "BottomSheetCalendarFragment")
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


