package com.example.mypage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CalendarView
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import java.util.*

class BottomSheetCalendarFragment : BottomSheetDialogFragment(){
    var listener: BottomSheetClickListener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_bottom_sheet_calendar, container, false)
        val calendarView = rootView.findViewById<CalendarView>(R.id.calendarView)

        calendarView.setOnDateChangeListener { _, year, month, dayOfMonth ->
            val calendar = Calendar.getInstance()
            calendar.set(year, month, dayOfMonth)

            val selectedDateInMillis = calendar.timeInMillis
            listener?.onDateSelected(selectedDateInMillis)
            dismiss() // 바텀시트 닫기
        }

        return rootView
    }
}