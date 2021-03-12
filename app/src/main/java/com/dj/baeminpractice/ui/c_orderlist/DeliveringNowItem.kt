package com.dj.baeminpractice.ui.c_orderlist

import android.view.View

import com.dj.baeminpractice.R

import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Item
import kotlinx.android.synthetic.main.item_delivering_now.view.*
import kotlinx.android.synthetic.main.item_record.view.*


class DeliveringNowItem(private val shopInfo: ShopInfo, private val adapterListener: AdapterListener) : Item<GroupieViewHolder>() {

    override fun getLayout() = R.layout.item_delivering_now

    companion object {
        var clickListener: AdapterListener? = null
    }

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {

        viewHolder.apply {
            with(viewHolder.itemView) {
                clickListener = adapterListener
                iv_phonecall.setOnClickListener(object : View.OnClickListener {
                    override fun onClick(v: View?) {
                        if (clickListener != null) {
                            clickListener?.onClickItem(this@DeliveringNowItem.shopInfo.shopName)
                        }
                    }
                })

                tv_phonecall.setOnClickListener(object : View.OnClickListener {
                    override fun onClick(v: View?) {
                        if (clickListener != null) {
                            clickListener?.onClickItem(this@DeliveringNowItem.shopInfo.shopName)
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