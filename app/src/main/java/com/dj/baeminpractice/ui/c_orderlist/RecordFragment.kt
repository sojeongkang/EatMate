package com.dj.baeminpractice.ui.c_orderlist

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.dj.baeminpractice.MainActivity
import com.dj.baeminpractice.R
import com.dj.baeminpractice.ui.d_community.ChattingFragment
import com.dj.baeminpractice.ui.d_community.ContentsUploadFragment
import com.dj.baeminpractice.ui.d_community.RecommendUploadFragment
import com.xwray.groupie.GroupieAdapter
import kotlinx.android.synthetic.main.fragment_record.view.*

class RecordFragment : Fragment(), RecordItem.AdapterListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_record, container, false)
        val adapter = GroupieAdapter()
        val dummyshop = ShopInfo("00카페")

        view.recyclerView_fragment_record.layoutManager = LinearLayoutManager(activity)
        view.recyclerView_fragment_record.adapter = adapter

        adapter.add(RecordItem(dummyshop,this))
        adapter.add(RecordItem(dummyshop, this))
        adapter.add(RecordItem(dummyshop, this))

        return view
    }

    override fun onClickItem(id: String) {
        (getActivity() as MainActivity).replaceFragment(RecommendUploadFragment().newInstance())
    }

}

