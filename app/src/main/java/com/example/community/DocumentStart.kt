package com.example.community

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.community.databinding.ActivityDocumentStartBinding

class DocumentStart : AppCompatActivity() {
    private val viewBinding: ActivityDocumentStartBinding by lazy {
        ActivityDocumentStartBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)
    }
}