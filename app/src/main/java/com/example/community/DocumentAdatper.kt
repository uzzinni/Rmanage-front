package com.example.community

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DocumentAdapter(private val dataList: MutableList<DocumentData>) :
    RecyclerView.Adapter<DocumentAdapter.DocumentViewHolder>() {

    class DocumentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val documentName: TextView = itemView.findViewById(R.id.document_name)
        val documentExpiryDate: TextView = itemView.findViewById(R.id.document_expiry_date)
        // 다른 뷰들도 여기서 초기화
    }

    fun addItem(newItem: DocumentData) {
        dataList.add(newItem)
        notifyItemInserted(dataList.size - 1)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DocumentViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.document_item, parent, false)
        return DocumentViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: DocumentViewHolder, position: Int) {
        val currentItem = dataList[position]

        holder.documentName.text = currentItem.documentType
        holder.documentExpiryDate.text = "유효기간: ${currentItem.documentPeriod}"
        // 다른 뷰들도 여기서 바인딩
    }

    override fun getItemCount() = dataList.size
}