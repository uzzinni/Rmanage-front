package com.example.community

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NoticeCommentAdapter(private val commentList: List<NoticePostDetail.CommentItem>) :
    RecyclerView.Adapter<NoticeCommentAdapter.CommentViewHolder>() {

    inner class CommentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val noticeCommentProfile: ImageView = itemView.findViewById(R.id.notice_comment_profile)
        val noticeCommentId: TextView = itemView.findViewById(R.id.notice_comment_id)
        val noticeCommentDate: TextView = itemView.findViewById(R.id.notice_comment_date)
        val noticeCommentTime: TextView = itemView.findViewById(R.id.notice_comment_time)
        val noticeCommentContent: TextView = itemView.findViewById(R.id.notice_comment_content)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.commentitemview, parent, false)
        return CommentViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        val currentItem = commentList[position]

        holder.noticeCommentProfile.setImageResource(R.drawable.profile) // 프로필 이미지 설정 나중에 마이페이지랑 연동 필요
        holder.noticeCommentId.text = currentItem.commenterName           //아이디 부분 로그인 연동 필요
        holder.noticeCommentDate.text = currentItem.commentDate
        holder.noticeCommentTime.text = currentItem.commentTime
        holder.noticeCommentContent.text = currentItem.commentContent
    }

    override fun getItemCount(): Int {
        return commentList.size
    }
}