package com.dj.baeminpractice.ui.a_home

import androidx.fragment.app.*
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.dj.baeminpractice.ui.a_home.MenuTab.MenuFragment

class PageAdapter(fragmentActivity: FragmentActivity,_fragmentList: List<Fragment>): FragmentStateAdapter(fragmentActivity){
    val fragmentList=_fragmentList

    override fun getItemCount(): Int =fragmentList.size
    override fun createFragment(position: Int): Fragment {

        return fragmentList[position]
    }
}