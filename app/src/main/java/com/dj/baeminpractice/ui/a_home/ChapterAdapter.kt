package com.dj.baeminpractice.ui.a_home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dj.baeminpractice.R
import com.dj.baeminpractice.model.Chapter
import java.util.*
import com.squareup.picasso.Picasso


class ChapterAdapter(private val context: Context, chapters: ArrayList<Chapter>) :
    RecyclerView.Adapter<ChapterAdapter.CustomViewHolder?>() {
    private val chapters: ArrayList<Chapter>
    private val inflater: LayoutInflater

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val chapter: Chapter = chapters[position]
        holder.tvChapterName.setText(chapter.chapterName)
        Picasso.get().load(chapter.imageUrl).into(holder.ivChapter)
    }

    inner class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var ivChapter: ImageView
        var tvChapterName: TextView

        init {
            tvChapterName = itemView.findViewById<View>(R.id.tvChapterName) as TextView
            ivChapter = itemView.findViewById<View>(R.id.ivChapter) as ImageView
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
        view = inflater.inflate(R.layout.single_chapter, parent, false)
        return CustomViewHolder(view)
    }


}
