package com.dj.baeminpractice.ui.d_community

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.dj.baeminpractice.MainActivity
import com.dj.baeminpractice.R
import com.dj.baeminpractice.ui.c_orderlist.DeliveringNowFragment
import com.dj.baeminpractice.ui.c_orderlist.RecordFragment
import com.dj.baeminpractice.ui.c_orderlist.RecruitingNowFragment
import com.dj.baeminpractice.ui.c_orderlist.ViewPagerAdapter
import kotlinx.android.synthetic.main.fragment_orderlist.view.*

class ChattingFragment: Fragment(R.layout.fragment_chatting){
    lateinit var chattingfragment: View

    fun newInstance():ChattingFragment {
        return ChattingFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        chattingfragment = inflater.inflate(R.layout.fragment_chatting, container, false)

        (getActivity() as MainActivity).fab_upload.hide()

        var adapter = ViewPagerAdapter(childFragmentManager)
        adapter.addFragment(FriendTabFragment(),"친구")
        adapter.addFragment(ChattingTabFragment(),"채팅")
        chattingfragment.c_viewPager.adapter = adapter
        chattingfragment.c_tablayout.setupWithViewPager(chattingfragment.c_viewPager)

        return chattingfragment
    }
}