package com.dj.baeminpractice.ui.d_community

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.dj.baeminpractice.R
import com.dj.baeminpractice.ui.c_orderlist.ShopInfo
import com.xwray.groupie.GroupieAdapter
import kotlinx.android.synthetic.main.fragment_chattingtab.view.*

class FriendTabFragment : Fragment(R.layout.fragment_friendtab){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    fun newInstance():FriendTabFragment {
        return FriendTabFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_friendtab, container, false)
        val adapter = GroupieAdapter()
        val dummyshop = ShopInfo("하늘카페")

        view.recyclerView.layoutManager = LinearLayoutManager(activity)
        view.recyclerView.adapter = adapter

        adapter.add(ChattingItem(dummyshop))
        adapter.add(ChattingItem(dummyshop))
        adapter.add(ChattingItem(dummyshop))

        return view
    }
}