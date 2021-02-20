package com.dj.baeminpractice.ui.a_home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageButton
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.dj.baeminpractice.MainActivity
import com.dj.baeminpractice.R
import com.dj.baeminpractice.ui.a_home.MenuTab.MenuActivity
import com.dj.baeminpractice.ui.c_favorite.FavoriteFragment
import com.dj.baeminpractice.ui.d_community.CommunityFragment
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment(R.layout.fragment_home), View.OnClickListener {

    lateinit var myFragment: View
    lateinit var viewPagers: ViewPager
    lateinit var tabLayouts: TabLayout

    fun newInstance(): HomeFragment {
        return HomeFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
        val fab_open = AnimationUtils.loadAnimation(this.context,R.anim.fab_open)
        val fab_close = AnimationUtils.loadAnimation(this.context, R.anim.fab_close)
        var isFabOpen = false

        (getActivity() as MainActivity).fab_main.show()

    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        myFragment = inflater.inflate(R.layout.fragment_home, container, false)
        return myFragment
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setUpViewPager()

        val fab_open = AnimationUtils.loadAnimation(this.context,R.anim.fab_open)
        val fab_close = AnimationUtils.loadAnimation(this.context, R.anim.fab_close)
        //var isFabOpen = false

        iv_address.setOnClickListener {
            val intent = Intent(getActivity(), AddressActivity::class.java)
            startActivity(intent)

        }


        tabLayouts.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {

                if (tab == null) {
                    // ((MainActivity)getActivity()).fab_main.hide()
                    (getActivity() as MainActivity).fab_main.hide()
                    (getActivity() as MainActivity).fab1.hide()
                    (getActivity() as MainActivity).fab2.hide()
                }
                    //fab_main.hide()
                else {
                    if (tab.position == 0) {
                        (getActivity() as MainActivity).fab_main.show()
                        (getActivity() as MainActivity).fab1.show()
                        (getActivity() as MainActivity).fab2.show()
                        //fab_main.show()
                        //fab.startAnimation(fab_open)

                    } else {
                        (getActivity() as MainActivity).fab_main.hide()
                        (getActivity() as MainActivity).fab1.hide()
                        (getActivity() as MainActivity).fab2.hide()
                        //fab_main.hide()
                        //fab1.startAnimation(fab_close)
                    }
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab == null) {
                    (getActivity() as MainActivity).fab_main.hide()
                    (getActivity() as MainActivity).fab1.hide()
                    (getActivity() as MainActivity).fab2.hide()
                }
                    //fab_main.hide()
                    //fab.startAnimation(fab_open)
                else {
                    if (tab.position == 0) {
                        (getActivity() as MainActivity).fab_main.show()
                        (getActivity() as MainActivity).fab1.show()
                        (getActivity() as MainActivity).fab2.show()
                        // fab_main.show()
                        //fab.startAnimation(fab_open)
                    } else {
                        // fab_main.hide()
                        (getActivity() as MainActivity).fab_main.hide()
                        (getActivity() as MainActivity).fab1.hide()
                        (getActivity() as MainActivity).fab2.hide()
                    }
                    // fab_main.startAnimation(fab_close)
                }
            }
        })

    }

    private fun setUpViewPager() {
        viewPagers = viewPager
        tabLayouts = tablayout

        var adapter = ViewPagerAdapter(requireFragmentManager())
        adapter.addFragment(RecruitFragment(), "모집중")
        adapter.addFragment(RoomFragment(), "방 생성")

        viewPagers!!.adapter = adapter
        tabLayouts!!.setupWithViewPager(viewPagers)
    }

    override fun onClick(v: View?) {
        v?.let {
            when (it.id) {
                R.id.fab1 ->{
                    toggleFab()
                }
                R.id.fab1 ->{
                    toggleFab()
                }

                R.id.fab2 ->{
                    toggleFab()
                }
                R.id.iv_address ->{
                    val intent = Intent(getActivity(), AddressActivity::class.java)
                    startActivity(intent)
                }

            }
        }
    }

    private fun toggleFab() {

        val fab_open = AnimationUtils.loadAnimation(this.context,R.anim.fab_open)
        val fab_close = AnimationUtils.loadAnimation(this.context, R.anim.fab_close)
        var isFabOpen = true

        if (isFabOpen)
        {
            fab1.setImageResource(R.drawable.f)
            fab1.startAnimation(fab_close)
            fab2.startAnimation(fab_close)
            fab1.setClickable(false)
            fab2.setClickable(false)
            isFabOpen = false
        }
        else
        {
            fab1.setImageResource(R.drawable.f)
            fab1.startAnimation(fab_open)
            fab2.startAnimation(fab_open)
            fab1.setClickable(true)
            fab2.setClickable(true)
            isFabOpen = true
        }
    }

}