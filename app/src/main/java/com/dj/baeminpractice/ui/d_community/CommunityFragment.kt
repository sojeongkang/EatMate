package com.dj.baeminpractice.ui.d_community


import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dj.baeminpractice.MainActivity
import com.dj.baeminpractice.R
import kotlinx.android.synthetic.main.fragment_community.*


class CommunityFragment: Fragment(R.layout.fragment_community){

    fun newInstance():CommunityFragment {
        return CommunityFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (getActivity() as MainActivity).fab_main.hide()
        (getActivity() as MainActivity).fab1.hide()
        (getActivity() as MainActivity).fab2.hide()
        (getActivity() as MainActivity).fab_upload.show()

        val contentAdapter = ContentAdapter()

        contentAdapter.addContent(Content(R.drawable.food2))
        contentAdapter.addContent(Content(R.drawable.food))
        contentAdapter.addContent(Content(R.drawable.food2))
        contentAdapter.addContent(Content(R.drawable.food))
        contentAdapter.addContent(Content(R.drawable.food2))

        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this.context)
        rv_content.setLayoutManager(layoutManager)
        rv_content.setAdapter(contentAdapter)

        (getActivity() as MainActivity).fab_upload.setOnClickListener(){
            (getActivity() as MainActivity).replaceFragment(ContentsUploadFragment().newInstance())
        }

        iv_chatting.setOnClickListener(){
            (getActivity() as MainActivity).replaceFragment(ChattingFragment().newInstance())
        }
    }

    fun replacement(){
        (getActivity() as MainActivity).replaceFragment(ChattingFragment().newInstance())
    }



}