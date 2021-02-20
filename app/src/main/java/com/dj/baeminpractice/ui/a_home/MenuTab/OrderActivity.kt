package com.dj.baeminpractice.ui.a_home.MenuTab

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.bumptech.glide.Glide
import com.dj.baeminpractice.R
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_menu.*
import kotlinx.android.synthetic.main.activity_order.*


class OrderActivity  : AppCompatActivity() {
    private lateinit var mContext : Context

    lateinit var viewPagers: ViewPager
    lateinit var tabView: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)
        mContext = applicationContext

        if (intent.hasExtra("title_order")) {
            tv_order_food.text = intent.getStringExtra("title_order")
        } else { Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show() }

        if (intent.hasExtra("img_order")) {
            Glide.with(this)
                .asBitmap()
                .load(intent.getStringExtra("img_order"))
                .into(iv_order_food);
        } else { Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show() }

    }


}