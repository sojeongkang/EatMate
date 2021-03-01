package com.dj.baeminpractice.ui.a_home.MenuTab

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.dj.baeminpractice.R
import com.dj.baeminpractice.ui.a_home.PageAdapter
import com.dj.baeminpractice.ui.a_home.RoomFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity  : AppCompatActivity() {
    private lateinit var mContext : Context

    lateinit var viewPagers: ViewPager2
    lateinit var tabView: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        mContext = applicationContext
        initViewPager() // 뷰페이저와 어댑터 장착

        if (intent.hasExtra("title")) {
            tv_foodtitle.text = intent.getStringExtra("title")
        } else { Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show() }

        if (intent.hasExtra("img")) {
            Glide.with(this)
                .asBitmap()
                .load(intent.getStringExtra("img"))
                .into(iv_foodimg);
        } else { Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show() }


    }


    private fun initViewPager(){

        val fragmentList:List<Fragment> = listOf(MenuFragment(),RoomFragment(),RoomFragment())

        val adapter = PageAdapter(this,fragmentList) // PageAdapter 생성

        viewPager.adapter = adapter // 뷰페이저에 adapter 장착

        val tabLayout = findViewById<TabLayout>(R.id.tablayout)   //fragment이기 때문에 root view에서 위젯 가져와야함.
        val tabLayoutTextArray= arrayListOf<String>("메뉴","리뷰","정보")    //tab이름 설정
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->         //tabLayout과 ViewPager를 연결해줌.
            tab.text=tabLayoutTextArray[position]
        }.attach()


    }
}