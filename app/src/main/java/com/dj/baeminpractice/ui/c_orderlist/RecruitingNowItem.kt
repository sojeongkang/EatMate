package com.dj.baeminpractice.ui.c_orderlist

import com.dj.baeminpractice.R
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Item

class RecruitingNowItem(private val shopInfo: ShopInfo) : Item<GroupieViewHolder>() {

    override fun getLayout() = R.layout.item_recruiting_now

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        //바인딩 코드 추가
    }
}