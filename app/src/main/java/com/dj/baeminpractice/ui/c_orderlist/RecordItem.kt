package com.dj.baeminpractice.ui.c_orderlist


import android.content.Intent
import android.view.View
import androidx.core.content.ContextCompat
import com.dj.baeminpractice.R
import com.dj.baeminpractice.ui.a_home.MenuTab.MenuActivity
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Item
import kotlinx.android.synthetic.main.item_delivering_now.view.*
import kotlinx.android.synthetic.main.item_record.view.*


class RecordItem(private val shopInfo: ShopInfo, private val adapterListener: RecordItem.AdapterListener) : Item<GroupieViewHolder>() {

    override fun getLayout() = R.layout.item_record

    companion object {
        var clickListener: RecordItem.AdapterListener? = null
    }

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {

        viewHolder.apply {
            with(viewHolder.itemView) {
                RecordItem.clickListener = adapterListener
                bt_review.setOnClickListener(object : View.OnClickListener {
                    override fun onClick(v: View?) {
                        if (RecordItem.clickListener != null) {
                            RecordItem.clickListener?.onClickItem(this@RecordItem.shopInfo.shopName)
                        }
                    }
                })
            }
        }
    }

    interface AdapterListener {
        fun onClickItem(id: String)
    }

}