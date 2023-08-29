package com.example.community

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.community.databinding.ActivityAlchatErrorBinding

class alchat_error : AppCompatActivity() {
    private val viewBinding: ActivityAlchatErrorBinding by lazy {
        ActivityAlchatErrorBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)
    }
}