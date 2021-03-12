package com.dj.baeminpractice.ui.c_orderlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.dj.baeminpractice.MainActivity
import com.dj.baeminpractice.R

import kotlinx.android.synthetic.main.fragment_orderlist.view.*

class OrderListFragment: Fragment(){
    lateinit var orderlistfragment: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        (getActivity() as MainActivity).fab_main.hide()
        (getActivity() as MainActivity).fab1.hide()
        (getActivity() as MainActivity).fab2.hide()
        (getActivity() as MainActivity).fab_upload.hide()

        orderlistfragment = inflater.inflate(R.layout.fragment_orderlist, container, false)

        var adapter = ViewPagerAdapter(childFragmentManager)
        adapter.addFragment(RecruitingNowFragment(),"모집중인 방")
        adapter.addFragment(DeliveringNowFragment(),"진행중인 배달")
        adapter.addFragment(RecordFragment(),"과거 주문내역")
        orderlistfragment.c_viewPager.adapter = adapter
        orderlistfragment.c_tablayout.setupWithViewPager(orderlistfragment.c_viewPager)

        return orderlistfragment
    }

}