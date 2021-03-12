package com.dj.baeminpractice.ui.b_eatwhat

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.dj.baeminpractice.MainActivity
import com.dj.baeminpractice.R
import com.dj.baeminpractice.model.data.fakeWhatToEatList
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_eat_what.*

class EatWhatFragment : Fragment(R.layout.fragment_eat_what) {
    private val eatWhatViewModel: EatWhatViewModel by viewModels()
    private lateinit var whatToEatAdapter: WhatToEatAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        eatWhatViewModel.getFakeWhatToEatList()
        (getActivity() as MainActivity).fab_main.hide()
        (getActivity() as MainActivity).fab1.hide()
        (getActivity() as MainActivity).fab2.hide()
        (getActivity() as MainActivity).fab_upload.hide()

        whatToEatAdapter = WhatToEatAdapter()
        recyclerView2.apply {
            layoutManager = LinearLayoutManager(this.context)
            adapter = whatToEatAdapter
        }

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
}