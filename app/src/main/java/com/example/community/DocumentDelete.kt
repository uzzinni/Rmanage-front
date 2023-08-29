package com.example.community

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import com.example.community.databinding.ActivityDocumentDeleteBinding
import com.example.community.databinding.ActivityDocumentPlusBinding

class DocumentDelete : AppCompatActivity() {
    private val viewBinding: ActivityDocumentDeleteBinding by lazy {
        ActivityDocumentDeleteBinding.inflate(layoutInflater)
    }

    private val selectedItems = mutableListOf<DocumentData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)


        findViewById<ImageButton>(R.id.btn_document_delete_back).setOnClickListener {
            val intent = Intent(this, DocumentDetail::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.btn_document_delete).setOnClickListener {
            val resultIntent = Intent()
            resultIntent.putParcelableArrayListExtra("deletedItems", ArrayList(selectedItems))
            setResult(Activity.RESULT_OK, resultIntent)
            finish()


        }
    }
}