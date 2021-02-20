package com.dj.baeminpractice.ui.a_home.MenuTab

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.dj.baeminpractice.R
import com.dj.baeminpractice.model.ChapterMenuTab
import com.squareup.picasso.Picasso
import java.util.ArrayList

class MenuChapterAdapter(private val context: Context, chapters: ArrayList<ChapterMenuTab>) :
    RecyclerView.Adapter<MenuChapterAdapter.CustomViewHolder?>() {
    private val chapters: ArrayList<ChapterMenuTab>
    private val inflater: LayoutInflater

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val chapter: ChapterMenuTab = chapters[position]
        //val whatToEatItem = getItem(position)
        holder.menu_tvChapterName.setText(chapter.chapterName)
        Picasso.get().load(chapter.imageUrl).into(holder.menu_ivChapter)

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView?.context, OrderActivity::class.java)
            //intent.putExtra("WhatToEatItem", "WhatToEatItem")
            intent.putExtra("img_order", chapter.imageUrl);
            intent.putExtra("title_order", chapter.chapterName)
            ContextCompat.startActivity(holder.itemView.context, intent, null)
        }
    }

    inner class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var menu_ivChapter: ImageView
        var menu_tvChapterName: TextView

        init {
            menu_tvChapterName = itemView.findViewById<View>(R.id.menu_tvChapterName) as TextView
            menu_ivChapter = itemView.findViewById<View>(R.id.menu_ivChapter) as ImageView
        }
    }

    init {
        this.chapters = chapters
        inflater = LayoutInflater.from(context)
    }

    override fun getItemCount(): Int {
        return chapters?.size ?: 0
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view: View
        view = inflater.inflate(R.layout.single_menu, parent, false)
        return CustomViewHolder(view)
    }


}