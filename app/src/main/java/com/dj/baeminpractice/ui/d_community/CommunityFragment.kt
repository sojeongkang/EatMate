package com.dj.baeminpractice.ui.d_community

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dj.baeminpractice.MainActivity
import com.dj.baeminpractice.R
import com.dj.baeminpractice.ui.a_home.HomeViewModel
import com.dj.baeminpractice.ui.a_home.RoomFragment
import com.dj.baeminpractice.ui.b_eatwhat.EatWhatViewModel
import kotlinx.android.synthetic.main.fragment_community.*
import kotlinx.android.synthetic.main.fragment_recruit.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive


class CommunityFragment: Fragment(R.layout.fragment_community){

    fun newInstance():CommunityFragment {
        return CommunityFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (getActivity() as MainActivity).fab_main.hide()

        val contentAdapter = ContentAdapter()

        contentAdapter.addContent(Content(R.drawable.food2))
        contentAdapter.addContent(Content(R.drawable.food))
        contentAdapter.addContent(Content(R.drawable.food2))
        contentAdapter.addContent(Content(R.drawable.food))
        contentAdapter.addContent(Content(R.drawable.food2))

        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this.context)
        rv_content.setLayoutManager(layoutManager)
        rv_content.setAdapter(contentAdapter)


        iv_chatting.setOnClickListener(){
           // getsupportFragmentManager().beginTransaction().replace(R.id.action_container, orderFragment
            //((MainActivity)getActivity()).replaceFragment(RoomFragment());

            (getActivity() as MainActivity).replaceFragment(RoomFragment().newInstance())
        }
    }




}