package com.dj.baeminpractice.ui.d_community

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.dj.baeminpractice.MainActivity
import com.dj.baeminpractice.R
import kotlinx.android.synthetic.main.fragment_contents_upload.*

class RecommendUploadFragment: Fragment(R.layout.fragment_recommend_upload){
    private lateinit var mContext : Context


    fun newInstance():RecommendUploadFragment {
        return RecommendUploadFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (getActivity() as MainActivity).fab_upload.hide()

        bt_upload.setOnClickListener {
            Toast.makeText(this.context, "업로드 완료", Toast.LENGTH_SHORT).show()
            (getActivity() as MainActivity).replaceFragment(CommunityFragment().newInstance())
            //서버에 콘텐츠 업로드하는 코드 작성

        }
    }


}