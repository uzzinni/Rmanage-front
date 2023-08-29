package com.example.community
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NoticePostAdapter(private val postList: MutableList<NoticePost>) :
    RecyclerView.Adapter<NoticePostAdapter.PostViewHolder>() {

    inner class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val postDate: TextView = itemView.findViewById(R.id.post_date)
        val postId: TextView = itemView.findViewById(R.id.post_id)
        val postTitle: TextView = itemView.findViewById(R.id.post_title)
        val postCount: TextView = itemView.findViewById(R.id.post_count)


        init {
            // 아이템 클릭 시 상세 페이지로 이동
            itemView.setOnClickListener {
                val context = itemView.context
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val clickedItem = postList[position]
                    val intent = Intent(context, NoticePostDetail::class.java)
                    intent.putExtra("position", position)
                    intent.putExtra("postId", clickedItem.post_id)
                    intent.putExtra("postTitle", clickedItem.post_title)
                    intent.putExtra("postContent", clickedItem.post_content)
                    intent.putExtra("postDate", clickedItem.post_date)
                    intent.putExtra("postTime", clickedItem.post_time)
                    // 추가적인 데이터를 필요한 대로 intent에 추가할 수 있습니다.
                    context.startActivity(intent)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.itemview, parent, false)
        return PostViewHolder(itemView)
    }

    fun removeItem(position: Int) {
        if (position in 0 until postList.size) {
            postList.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeRemoved(position, postList.size)
            notifyDataSetChanged()
        }
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val currentItem = postList[position]
        holder.postDate.text = currentItem.post_date
        holder.postId.text = currentItem.post_id
        holder.postTitle.text = currentItem.post_title
        holder.postCount.text = currentItem.post_count.toString()
    }

    override fun getItemCount(): Int {
        return postList.size
    }
}