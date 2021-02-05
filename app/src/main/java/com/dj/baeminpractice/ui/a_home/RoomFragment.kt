package com.dj.baeminpractice.ui.a_home


import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.dj.baeminpractice.R
import com.dj.baeminpractice.model.BannerItem
import com.dj.baeminpractice.ui.EventActivity
import com.dj.baeminpractice.ui.b_eatwhat.GridRecyclerViewAdapter
import com.dj.baeminpractice.ui.b_eatwhat.HomeViewModel
import com.dj.baeminpractice.ui.b_eatwhat.Interaction
import com.dj.baeminpractice.ui.collapse
import com.dj.baeminpractice.ui.expand
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_room.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive


class RoomFragment : Fragment(R.layout.fragment_room) {

    private lateinit var gridRecyclerViewAdapter: GridRecyclerViewAdapter
    private lateinit var viewPagerAdapter2: ViewPagerAdapter2
    private val homeViewModel: HomeViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initGridRecyclerView()
        autoScrollViewPager()
        subscribeObservers()
    }

    private fun subscribeObservers() {
        //homeViewModel.bannerItemList.observe(viewLifecycleOwner, Observer {
        //    viewPagerAdapter2.submitList(it)
       // })
        homeViewModel.gridItemList.observe(viewLifecycleOwner, Observer {
            gridRecyclerViewAdapter.submitList(it)
        })

       // homeViewModel.currentPosition.observe(viewLifecycleOwner, Observer {
         //   viewPager2.currentItem = it
       // })
    }

    private fun autoScrollViewPager() {
        viewLifecycleOwner.lifecycleScope.launchWhenResumed {
            while (viewLifecycleOwner.lifecycleScope.isActive) {
                delay(3000)
                homeViewModel.getCurrentPosition()?.let {
                    homeViewModel.setCurrentPosition(it.plus(1) % 5)
                }
            }
        }
    }

    private fun initGridRecyclerView() {
        gridRecyclerView.apply {
            gridRecyclerViewAdapter = GridRecyclerViewAdapter()
            layoutManager = GridLayoutManager(this@RoomFragment.context, 4)
            adapter = gridRecyclerViewAdapter

        }
    }

    override fun onResume() {
        super.onResume()
        homeViewModel.getGridItems()
    }
}