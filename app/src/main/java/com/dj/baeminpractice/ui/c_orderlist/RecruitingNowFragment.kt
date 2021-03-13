package com.dj.baeminpractice.ui.c_orderlist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.dj.baeminpractice.R
import com.xwray.groupie.GroupieAdapter
import kotlinx.android.synthetic.main.fragment_recruiting_now.view.*

class RecruitingNowFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_recruiting_now, container, false)
        val adapter = GroupieAdapter()
        val dummyshop = ShopInfo("하늘카페")

        adapter.add(RecruitingNowItem(dummyshop))
        adapter.add(RecruitingNowItem(dummyshop))
        adapter.add(RecruitingNowItem(dummyshop))

        view.recyclerView_recuriting_now.layoutManager = LinearLayoutManager(activity)
        view.recyclerView_recuriting_now.adapter = adapter

        return view
    }
}