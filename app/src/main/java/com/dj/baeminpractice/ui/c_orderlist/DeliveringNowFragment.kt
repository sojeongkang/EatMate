package com.dj.baeminpractice.ui.c_orderlist

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.dj.baeminpractice.R
import com.xwray.groupie.GroupieAdapter
import kotlinx.android.synthetic.main.fragment_delivering_now.view.*

class DeliveringNowFragment : Fragment(), DeliveringNowItem.AdapterListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_delivering_now, container, false)
        val adapter = GroupieAdapter()
        val dummyshop = ShopInfo("하늘카페")

        view.recyclerView_delivering_now.layoutManager = LinearLayoutManager(activity)
        view.recyclerView_delivering_now.adapter = adapter

        adapter.add(DeliveringNowItem(dummyshop, this ))
        adapter.add(DeliveringNowItem(dummyshop, this))
        adapter.add(DeliveringNowItem(dummyshop, this))

        return view
    }

    override fun onClickItem(id: String) {

        val mDialogView = layoutInflater.inflate(R.layout.dialog_phonecall, null)
        //builder.setView(layoutInflater.inflate(R.layout.dialog_phonecall, null))
        val mBuilder = AlertDialog.Builder(this.requireContext())
            .setView(mDialogView)

        val  mAlertDialog = mBuilder.show()

        val callDriverBt = mDialogView.findViewById<Button>(R.id.bt_call_deliver)
        callDriverBt.setOnClickListener {
            var intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "114"))
            //var intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + driver_PhoneNum))
            startActivity(intent)
        }

        val callShopBt = mDialogView.findViewById<Button>(R.id.bt_call_shop)
        callShopBt.setOnClickListener {
            var intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "01011112222"))
            //var intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + shop_PhoneNum))
            startActivity(intent)
        }


        //builder.setPositiveButton("확인", listener)
        //builder.setNegativeButton("취소", null)
        //builder.show()


    }

}