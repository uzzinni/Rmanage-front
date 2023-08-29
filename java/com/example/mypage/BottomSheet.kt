package com.example.mypage

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class
    BottomSheetFragment : BottomSheetDialogFragment() {
    private lateinit var document1TextView: TextView
    private lateinit var document2TextView: TextView
    private lateinit var document3TextView: TextView
    var listener: BottomSheetClickListener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_bottom_sheet, container, false)
        document1TextView = rootView.findViewById(R.id.docunment_1)
        document2TextView = rootView.findViewById(R.id.docunment_2)
        document3TextView = rootView.findViewById(R.id.docunment_3)

        // 각 텍스트뷰에 클릭 리스너 설정
        document1TextView.setOnClickListener { updateText(document1TextView) }
        document2TextView.setOnClickListener { updateText(document2TextView) }
        document3TextView.setOnClickListener { updateText(document3TextView) }

        return rootView
    }

    @SuppressLint("SetTextI18n")
    private fun updateText(textView: TextView) {
        val newText = textView.text.toString()

        // 액티비티 내에서 리스너에게 알림
        listener?.onTextViewClicked(newText)

        dismiss()
    }
}