package com.example.community
import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager

class ReverseLinearLayoutManager(context: Context) : LinearLayoutManager(context) {
    override fun supportsPredictiveItemAnimations(): Boolean {
        return false
    }

    override fun getReverseLayout(): Boolean {
        return true
    }

    override fun getStackFromEnd(): Boolean {
        return true
    }
}
