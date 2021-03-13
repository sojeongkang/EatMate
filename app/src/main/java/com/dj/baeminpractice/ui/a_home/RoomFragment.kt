package com.dj.baeminpractice.ui.a_home


import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.dj.baeminpractice.R
import com.dj.baeminpractice.model.Chapter
import com.dj.baeminpractice.model.Subject
import com.dj.baeminpractice.ui.b_eatwhat.EatWhatViewModel
import com.dj.baeminpractice.ui.d_community.CommunityFragment
import kotlinx.android.synthetic.main.fragment_room.*
import kotlinx.android.synthetic.main.fragment_room.gridRecyclerView
import java.util.*


//viwmodel 적용시키기
class RoomFragment: Fragment(R.layout.fragment_room){
    private lateinit var gridRecyclerViewAdapter: GridRecyclerViewAdapter
    private val eatWhatViewModel: EatWhatViewModel by viewModels()
    private val homeViewModel: HomeViewModel by viewModels()

    private lateinit var subjectAdapter: SubjectAdapter
    private lateinit var subjects: ArrayList<Subject>

    fun newInstance(): RoomFragment {
        return RoomFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initGridRecyclerView()
        subscribeObservers()

        val roomViewModel : RoomViewModel by viewModels()

        subjects = roomViewModel.getData()
        subjectAdapter = SubjectAdapter(subjects, this.requireContext())

        rvSubject.apply {
            layoutManager = LinearLayoutManager(this.context)
            adapter = subjectAdapter
        }

    }


    private fun subscribeObservers() {

        homeViewModel.gridItemList.observe(viewLifecycleOwner, Observer {
            gridRecyclerViewAdapter.submitList(it)
        })

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