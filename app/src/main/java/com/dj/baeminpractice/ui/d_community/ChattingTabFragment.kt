package com.dj.baeminpractice.ui.d_community

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.dj.baeminpractice.R
import com.dj.baeminpractice.ui.c_orderlist.RecordItem
import com.dj.baeminpractice.ui.c_orderlist.ShopInfo
import com.xwray.groupie.GroupieAdapter
import kotlinx.android.synthetic.main.fragment_chattingtab.view.*
import kotlinx.android.synthetic.main.fragment_record.view.*
import kotlinx.android.synthetic.main.fragment_record.view.recyclerView_fragment_record

class ChattingTabFragment: Fragment(R.layout.fragment_chattingtab){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    fun newInstance():ChattingTabFragment {
        return ChattingTabFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_chattingtab, container, false)
        val adapter = GroupieAdapter()
        val dummyshop = ShopInfo("00카페")

        view.recyclerView.layoutManager = LinearLayoutManager(activity)
        view.recyclerView.adapter = adapter

        adapter.add(ChattingItem(dummyshop))
        adapter.add(ChattingItem(dummyshop))
        adapter.add(ChattingItem(dummyshop))

        return view
    }
}