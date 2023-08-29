package com.example.community

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.PopupMenu
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.community.databinding.ActivityDocumentDetailBinding

class DocumentDetail : AppCompatActivity() {
    private val viewBinding: ActivityDocumentDetailBinding by lazy {
        ActivityDocumentDetailBinding.inflate(layoutInflater)
    }
    private lateinit var adapter: DocumentAdapter

    private val documentDataList = mutableListOf<DocumentData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)

        findViewById<Button>(R.id.btn_document_add1).setOnClickListener {
            val intent = Intent(this, DocumentPlus::class.java)
            startActivityForResult(intent, REQUEST_DOCUMENT_PLUS)
        }

        val documentDataList = mutableListOf<DocumentData>()
        adapter = DocumentAdapter(documentDataList)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerview_document_detail)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        val documentData = intent.getSerializableExtra("documentData") as? DocumentData
        documentData?.let {
            val textView1: TextView = findViewById(R.id.document_name)
            val textView2: TextView = findViewById(R.id.document_expiry_date)
            textView1.text = it.documentType
            textView2.text = it.documentPeriod
        }

        val btnNoticeDetailMenu = findViewById<ImageButton>(R.id.btn_document_detail_popup)
        btnNoticeDetailMenu.setOnClickListener {
            val popupMenu = PopupMenu(this, it)
            popupMenu.inflate(R.menu.doc_menu)

            popupMenu.setOnMenuItemClickListener { menuItem ->
                when (menuItem.itemId) {
                    R.id.doc_popup_edit -> {
                        true
                    }
                    R.id.doc_popup_delete -> {
                        val selectedItems = getSelectedItems() // 체크한 아이템들을 가져오는 로직
                        val updatedDataList = documentDataList.filter { !selectedItems.contains(it) }

                        val intent = Intent(this, DocumentDetail::class.java)
                        intent.putParcelableArrayListExtra("updatedDocumentDataList", ArrayList(updatedDataList))
                        setResult(Activity.RESULT_OK, intent)
                        finish()
                        true
                    }
                    else -> false
                }
            }

            popupMenu.show()
        }

    }

    private fun getSelectedItems(): List<DocumentData> {
        val selectedItems = mutableListOf<DocumentData>()
        for (item in documentDataList) {
            // 아이템의 체크 여부를 확인하고 선택된 아이템 리스트에 추가
            // 예: if (item.isChecked) selectedItems.add(item)
        }
        return selectedItems
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_DOCUMENT_DELETE && resultCode == Activity.RESULT_OK) {
            val deletedItems = data?.getParcelableArrayListExtra<DocumentData>("deletedItems")
            deletedItems?.let {
                for (deletedItem in deletedItems) {
                    val index = documentDataList.indexOfFirst { it.id == deletedItem.id }
                    if (index != -1) {
                        documentDataList.removeAt(index)
                    }
                }
                adapter.notifyDataSetChanged()
            }
        } else if (requestCode == REQUEST_DOCUMENT_PLUS && resultCode == Activity.RESULT_OK) {
            val newItem = data?.getParcelableExtra<DocumentData>("documentData")
            newItem?.let {
                documentDataList.add(it)
                adapter.addItem(it)
                adapter.notifyDataSetChanged()
            }
        }
    }
    companion object {
        const val REQUEST_DOCUMENT_PLUS = 100
        const val REQUEST_DOCUMENT_DELETE = 101
    }
}