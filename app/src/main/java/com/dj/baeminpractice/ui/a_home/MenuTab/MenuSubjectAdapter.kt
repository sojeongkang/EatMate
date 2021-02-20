package com.dj.baeminpractice.ui.a_home.MenuTab

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dj.baeminpractice.R
import com.dj.baeminpractice.model.SubjectMenuTab
import java.util.ArrayList

class MenuSubjectAdapter(subjects: ArrayList<SubjectMenuTab>, context: Context) :
    RecyclerView.Adapter<MenuSubjectAdapter.ViewHolder?>() {
    var subjects: ArrayList<SubjectMenuTab>
    private val context: Context
    private val layoutInflater: LayoutInflater


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.recyclerView.setAdapter(subjects[position].chapters?.let {
            MenuChapterAdapter(
                context, it
            )
        })
        holder.recyclerView.setLayoutManager(
            LinearLayoutManager(
                context,
                LinearLayoutManager.VERTICAL,
                false
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