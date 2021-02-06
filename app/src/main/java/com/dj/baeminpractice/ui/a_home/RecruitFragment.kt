package com.dj.baeminpractice.ui.a_home

import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.dj.baeminpractice.R
import com.dj.baeminpractice.ui.b_eatwhat.EatWhatViewModel
import com.dj.baeminpractice.ui.b_eatwhat.HomeViewModel
import com.dj.baeminpractice.ui.b_eatwhat.WhatToEatAdapter
import kotlinx.android.synthetic.main.fragment_eat_what.*
import kotlinx.android.synthetic.main.fragment_recruit.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive

class RecruitFragment : Fragment(R.layout.fragment_recruit) {

    private val eatWhatViewModel: EatWhatViewModel by viewModels()
    private val homeViewModel: HomeViewModel by viewModels()
    private lateinit var whatToEatAdapter: WhatToEatAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        eatWhatViewModel.getFakeWhatToEatList()

        whatToEatAdapter = WhatToEatAdapter()
        recyclerView.apply {
            layoutManager = LinearLayoutManager(this.context)
            adapter = whatToEatAdapter
        }
        autoScrollViewPager()
        subscribeObservers()
    }

    private fun subscribeObservers() {
        eatWhatViewModel.eatWhatToEatList.observe(
            viewLifecycleOwner,
            Observer { fakeWhatToEatList ->
                fakeWhatToEatList?.let {
                    whatToEatAdapter.apply {
                        setList(fakeWhatToEatList)
                    }
                }
            })
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

}