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

        subjects = prepareData()
        subjectAdapter = SubjectAdapter(subjects, this.requireContext())

        rvSubject.apply {
            layoutManager = LinearLayoutManager(this.context)
            adapter = subjectAdapter
        }

    }


    private fun prepareData(): ArrayList<Subject> {
        val subjects = ArrayList<Subject>()
        val physics = Subject()
        physics.id = 1
        physics.subjectName = "우리 동네 가까운 음식점"
        physics.chapters = ArrayList<Chapter>()
        val chapter1 = Chapter()
        chapter1.id = 1
        chapter1.chapterName = "피자스쿨"
        chapter1.imageUrl = "https://t1.daumcdn.net/cfile/tistory/99A7EB3C5EAD9D5608"
        val chapter2 = Chapter()
        chapter2.id = 2
        chapter2.chapterName = "롯데리아"
        chapter2.imageUrl = "https://images2.minutemediacdn.com/image/upload/c_crop,h_1126,w_2000,x_0,y_181/f_auto,q_auto,w_1100/v1554932288/shape/mentalfloss/12531-istock-637790866.jpg"
        val chapter3 = Chapter()
        chapter3.id = 3
        chapter3.chapterName = "BBQ"
        chapter3.imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSiK4qphluVvv3FLf-M2VTJyjLLRxJuVnryeQ&usqp=CAU"
        val chapter4 = Chapter()
        chapter4.id = 4
        chapter4.chapterName = "엽기떡볶이"
        chapter4.imageUrl = "https://t1.daumcdn.net/cfile/tistory/2617694055CC59B219"
        val chapter5 = Chapter()
        chapter5.id = 5
        chapter5.chapterName = "홍콩반점"
        chapter5.imageUrl = "https://post-phinf.pstatic.net/MjAxODExMjJfMTQw/MDAxNTQyODU1NDM0MzQ2.7EAEnYyVkicz_SUtMMekLqrdFmLcOT3DHIX17o7khDMg.A0NAUSJUYPCs1Md4N16e0FguvsiqfbLxHeWJJ0ANHOsg.JPEG/1.jpg?type=w1200"
        physics.chapters!!.add(chapter1)
        physics.chapters!!.add(chapter2)
        physics.chapters!!.add(chapter3)
        physics.chapters!!.add(chapter4)
        physics.chapters!!.add(chapter5)
        val chem = Subject()
        chem.id = 2
        chem.subjectName = "찜(♡)이 많은 인기점"
        chem.chapters = ArrayList<Chapter>()
        val chapter6 = Chapter()
        chapter6.id = 6
        chapter6.chapterName = "샐러드파티"
        chapter6.imageUrl = "https://images.unsplash.com/photo-1498837167922-ddd27525d352?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=2850&q=80"
        val chapter7 = Chapter()
        chapter7.id = 7
        chapter7.chapterName = "엽기떡볶이"
        chapter7.imageUrl = "https://t1.daumcdn.net/cfile/tistory/2617694055CC59B219"
        val chapter8 = Chapter()
        chapter8.id = 8
        chapter8.chapterName = "Periodic table"
        chapter8.imageUrl = "http://ashishkudale.com/images/chem/periodic_table.png"
        val chapter9 = Chapter()
        chapter9.id = 9
        chapter9.chapterName = "Acid and Base"
        chapter9.imageUrl = "http://ashishkudale.com/images/chem/chem.png"
        chem.chapters!!.add(chapter6)
        chem.chapters!!.add(chapter7)
        chem.chapters!!.add(chapter8)
        chem.chapters!!.add(chapter9)
        val bio = Subject()
        bio.id = 3
        bio.subjectName = "입맛 저격! 추천 메뉴"
        bio.chapters = ArrayList<Chapter>()
        val chapter10 = Chapter()
        chapter10.id = 10
        chapter10.chapterName = "스테이크"
        chapter10.imageUrl = "https://i2.wp.com/www.foodrepublic.com/wp-content/uploads/2012/05/testkitchen_argentinesteak.jpg?resize=1280%2C%20560&ssl=1"
        val chapter11 = Chapter()
        chapter11.id = 11
        chapter11.chapterName = "무공돈까스"
        chapter11.imageUrl = "https://mp-seoul-image-production-s3.mangoplate.com/411765/1148532_1581472080598_6812?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80"
        val chapter12 = Chapter()
        chapter12.id = 12
        chapter12.chapterName = "Study of microscope"
        chapter12.imageUrl = "http://ashishkudale.com/images/bio/microscope.png"
        val chapter13 = Chapter()
        chapter13.id = 13
        chapter13.chapterName = "Protein and fibers"
        chapter13.imageUrl = "http://ashishkudale.com/images/bio/protein.png"
        bio.chapters!!.add(chapter10)
        bio.chapters!!.add(chapter11)
        bio.chapters!!.add(chapter12)
        bio.chapters!!.add(chapter13)
        val maths = Subject()
        maths.id = 4
        maths.subjectName = "저렴한 메뉴"
        maths.chapters = ArrayList<Chapter>()
        val chapter14 = Chapter()
        chapter14.id = 14
        chapter14.chapterName = "맥도날드"
        chapter14.imageUrl = "https://post-phinf.pstatic.net/MjAxODAzMjBfMzIg/MDAxNTIxNTE3OTI5NjYw.Lqi3GdGkLW4HdM9pQjopsVXHO068Xbj-G8rpj_JzUjkg.zIOQfGGN0Oa-FMvjldPLwy01NHOCiDDvxAsMwRew68og.PNG/2018-03-20_11%3B32%3B59.PNG?type=w1200"
        val chapter15 = Chapter()
        chapter15.id = 15
        chapter15.chapterName = "롯데리아"
        chapter15.imageUrl = "https://t1.daumcdn.net/liveboard/dailylife/f71ce71d08a44177b28821e30d72b060.jpg"
        val chapter16 = Chapter()
        chapter16.id = 16
        chapter16.chapterName = "이삭토스트"
        chapter16.imageUrl = "http://image.auction.co.kr/itemimage/1b/fb/45/1bfb451e46.jpg"
        val chapter17 = Chapter()
        chapter17.id = 17
        chapter17.chapterName = "Graph"
        chapter17.imageUrl = "http://ashishkudale.com/images/maths/plot.png"
        val chapter18 = Chapter()
        chapter18.id = 18
        chapter18.chapterName = "Trigonometry"
        chapter18.imageUrl = "http://ashishkudale.com/images/maths/trigonometry.png"
        maths.chapters!!.add(chapter14)
        maths.chapters!!.add(chapter18)
        maths.chapters!!.add(chapter15)
        maths.chapters!!.add(chapter16)
        maths.chapters!!.add(chapter17)
        subjects.add(physics)
        subjects.add(chem)
        subjects.add(maths)
        subjects.add(bio)
        return subjects
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