package com.dj.baeminpractice.ui.d_community


import android.app.PendingIntent.getActivity
import android.content.Context
import android.view.LayoutInflater;
import android.view.View;

import android.view.ViewGroup;
import android.widget.Button
import android.widget.ImageView;
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContentProviderCompat.requireContext

import androidx.recyclerview.widget.RecyclerView;
import com.dj.baeminpractice.MainActivity
import com.dj.baeminpractice.R

import kotlinx.android.synthetic.main.item_delivering_now.view.*

import kotlinx.android.synthetic.main.item_layout_content.view.*
import java.security.AccessController.getContext

import java.util.ArrayList;


class ContentAdapter : RecyclerView.Adapter<ContentAdapter.MyViewHolder>() {

    private val contents: MutableList<Content> = ArrayList()
    fun addContent(content: Content) {
        contents.add(content)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val view: View = inflater.inflate(R.layout.item_layout_content, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val content = contents[position]
        holder.setContent(content)

        var viewholder = holder.itemView

        viewholder.iv_heart.setOnClickListener {
            if(viewholder.iv_heart.drawable.equals(R.drawable.heart)){
                viewholder.iv_heart.setImageResource(R.drawable.like)
                //찜하기 서버 연동 코드 작성
            }
            else {
                viewholder.iv_heart.setImageResource(R.drawable.heart)
            }
        }

        viewholder.iv_profile.setOnClickListener {
            var layoutInflater = LayoutInflater.from(viewholder.context)
            val mDialogView = layoutInflater.inflate(R.layout.dialog_profile, null)
            val mBuilder = AlertDialog.Builder(holder.itemView?.context)
                .setView(mDialogView)

            val  mAlertDialog = mBuilder.show()

            val callDriverBt = mDialogView.findViewById<Button>(R.id.bt_profile_chat)
            callDriverBt.setOnClickListener {
                Toast.makeText(holder.itemView?.context, "채팅하기 클릭", Toast.LENGTH_SHORT).show()
                //replacement() as CommunityFragment)
            }

            val callShopBt = mDialogView.findViewById<Button>(R.id.bt_profile_report)
            callShopBt.setOnClickListener {
                Toast.makeText(holder.itemView?.context, "신고하기 클릭", Toast.LENGTH_SHORT).show()
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