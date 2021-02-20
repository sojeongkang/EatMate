package com.dj.baeminpractice.ui.d_community

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;
import com.dj.baeminpractice.R

import kotlinx.android.synthetic.main.item_detail.view.*
import kotlinx.android.synthetic.main.layout_content.view.*

import java.util.ArrayList;


class ContentAdapter : RecyclerView.Adapter<ContentAdapter.MyViewHolder>() {
    private val contents: MutableList<Content> = ArrayList()
    fun addContent(content: Content) {
        contents.add(content)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view: View = inflater.inflate(R.layout.layout_content, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val content = contents[position]
        holder.setContent(content)

        var viewholder = holder.itemView

        viewholder.iv_heart.setOnClickListener {
            if(viewholder.iv_heart.drawable.equals(R.drawable.heart)){
                viewholder.iv_heart.setImageResource(R.drawable.like)
            }
            else {
                viewholder.iv_heart.setImageResource(R.drawable.heart)
            }

        }

    }

    override fun getItemCount(): Int {
        return contents.size
    }

    // ViewHolder (뷰들의 책꽂이)
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // 뷰홀더
        // 규칙1 (xml이 들고있는 뷰)
        private val imageView3: ImageView

        // 규칙3
        fun setContent(content: Content) {
            imageView3.setImageResource(content.imgResource)
        }

        init {
            imageView3 = itemView.findViewById(R.id.imageView3)
        }
    }

    companion object {
        private const val TAG = "ContentAdapter"
    }
}