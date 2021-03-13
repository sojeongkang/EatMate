package com.dj.baeminpractice.ui.d_community

import com.dj.baeminpractice.R
import com.dj.baeminpractice.ui.c_orderlist.ShopInfo
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Item

class ChattingItem(private val shopInfo: ShopInfo) : Item<GroupieViewHolder>() {
    override fun getLayout() = R.layout.item_chatting

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        //바인딩 코드 추가

    }
}