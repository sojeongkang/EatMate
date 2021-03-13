package com.dj.baeminpractice.ui.e_profile

import android.content.Context
import android.os.Bundle
import android.os.Parcel
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.dj.baeminpractice.R
import kotlinx.android.synthetic.main.fragment_profile.*
import kotlinx.android.synthetic.main.mypage_item.view.*

class ProfileFragment: Fragment(R.layout.fragment_profile){

    var adapter: ProfileAdapter? = null
    var mypageMenuList = ArrayList<mypageMenu>()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        mypageMenuList.add(mypageMenu("찜한 가게", R.drawable.heart2))
        mypageMenuList.add(mypageMenu("주소 관리", R.drawable.location1))
        mypageMenuList.add(mypageMenu("내가 쓴 글", R.drawable.postit))
        mypageMenuList.add(mypageMenu("결제 관리", R.drawable.credit_card))
        mypageMenuList.add(mypageMenu("설정", R.drawable.gear))
        mypageMenuList.add(mypageMenu("고객 지원", R.drawable.telephone))
        adapter = ProfileAdapter(getActivity(), mypageMenuList)

        gridView_menu.adapter = adapter

    }

    class ProfileAdapter() : BaseAdapter() {
        var mypageMenuList = ArrayList<mypageMenu>()
        var context: Context? = null
        constructor(parcel: Parcel) : this() {
        }

        constructor(context: FragmentActivity?, mypageMenuList: ArrayList<mypageMenu>) : this() {
            this.context = context
            this.mypageMenuList = mypageMenuList
        }

        override fun getCount(): Int {
            return mypageMenuList.size
        }

        override fun getItem(position: Int): Any {
            return mypageMenuList[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val profile = this.mypageMenuList[position]

            var inflator =
                context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var profileView = inflator.inflate(R.layout.mypage_item, null)
            profileView.gridImg.setImageResource(profile.image!!)
            profileView.gridName.text = profile.name!!

            return profileView
        }
    }
}