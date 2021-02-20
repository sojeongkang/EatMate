package com.dj.baeminpractice.ui.a_home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dj.baeminpractice.R
import com.dj.baeminpractice.model.Subject
import java.util.*

class SubjectAdapter(subjects: ArrayList<Subject>, context: Context) :
    RecyclerView.Adapter<SubjectAdapter.ViewHolder?>() {
    var subjects: ArrayList<Subject>
    private val context: Context
    private val layoutInflater: LayoutInflater


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.recyclerView.setAdapter(subjects[position].chapters?.let {
            ChapterAdapter(context, it)
        })
        holder.recyclerView.setLayoutManager(
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false
            )
        )
        holder.recyclerView.setHasFixedSize(true)
        holder.tvHeading.setText(subjects[position].subjectName)
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var recyclerView: RecyclerView
        var tvHeading: TextView

        init {
            recyclerView = itemView.findViewById<View>(R.id.rvChapters) as RecyclerView
            tvHeading = itemView.findViewById<View>(R.id.tvSubjectName) as TextView
        }
    }

    init {
        this.subjects = subjects
        this.context = context
        layoutInflater = LayoutInflater.from(context)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = layoutInflater.inflate(R.layout.single_subject, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return subjects?.size ?: 0
    }
}