package com.dj.baeminpractice.ui.a_home.CategoryTab

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.bumptech.glide.Glide
import com.dj.baeminpractice.R
import com.dj.baeminpractice.ui.a_home.MenuTab.MenuFragment
import com.dj.baeminpractice.ui.a_home.PageAdapter
import com.dj.baeminpractice.ui.a_home.RecruitFragment
import com.dj.baeminpractice.ui.a_home.RoomFragment
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_category.*
import kotlinx.android.synthetic.main.activity_menu.*

class CategoryActivity  : AppCompatActivity() {
    private lateinit var mContext : Context

    lateinit var viewPagers: ViewPager
    lateinit var tabView: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)
        mContext = applicationContext
        initViewPager() // 뷰페이저와 어댑터 장착

        /*
        if (intent.hasExtra("title")) {
            tv_foodtitle.text = intent.getStringExtra("title")
        } else { Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show() }

        if (intent.hasExtra("img")) {
            Glide.with(this)
                .asBitmap()
                .load(intent.getStringExtra("img"))
                .into(iv_foodimg);
        } else { Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show() }
*/

    }


    private fun initViewPager(){

        val adapter = PageAdapter(supportFragmentManager) // PageAdapter 생성
        adapter.addFragment(RecruitFragment(), "1인분")
        adapter.addFragment(RecruitFragment(), "한식")
        adapter.addFragment(RecruitFragment(), "일식")
        adapter.addFragment(RecruitFragment(), "중식")
        adapter.addFragment(RecruitFragment(), "치킨")

        category_viewPager.adapter = adapter // 뷰페이저에 adapter 장착
        category_tablayout.setupWithViewPager(category_viewPager) // 탭레이아웃과 뷰페이저를 연동

    }
}