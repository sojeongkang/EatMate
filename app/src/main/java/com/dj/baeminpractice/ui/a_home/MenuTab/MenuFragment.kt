package com.dj.baeminpractice.ui.a_home.MenuTab

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.dj.baeminpractice.R
import com.dj.baeminpractice.model.ChapterMenuTab
import com.dj.baeminpractice.model.SubjectMenuTab
import com.dj.baeminpractice.ui.a_home.HomeViewModel

import com.dj.baeminpractice.ui.b_eatwhat.EatWhatViewModel
import kotlinx.android.synthetic.main.fragment_menu.*
import java.util.ArrayList

class MenuFragment: Fragment(R.layout.fragment_menu){

    private lateinit var subjectAdapter: MenuSubjectAdapter
    private lateinit var subjects: ArrayList<SubjectMenuTab>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        subjects = prepareData()
        subjectAdapter = MenuSubjectAdapter(subjects, this.requireContext())

        rvSubject.setNestedScrollingEnabled(false);

        rvSubject.apply {
            layoutManager = LinearLayoutManager(this.context)
            adapter = subjectAdapter
        }
    }


    private fun prepareData(): ArrayList<SubjectMenuTab> {
        val subjects = ArrayList<SubjectMenuTab>()
        val physics = SubjectMenuTab()
        physics.id = 1
        physics.subjectName = "대표 메뉴"
        physics.chapters = ArrayList<ChapterMenuTab>()
        val chapter1 = ChapterMenuTab()
        chapter1.id = 1
        chapter1.chapterName = "치즈 돈카츠"
        chapter1.imageUrl = "https://mblogthumb-phinf.pstatic.net/MjAyMDEwMDFfMTI0/MDAxNjAxNTM3NTA0MTIx.PTyUwFpjUEp975JB7KjEpyuPQMY80jAPAYaC1vyGRacg.WIrYJKg9io9nMl2Hc7jR1QNomYZG285d7pcxnbbYrwog.JPEG.gksal826/IMG_1367.jpg?type=w2"
        val chapter2 = ChapterMenuTab()
        chapter2.id = 2
        chapter2.chapterName = "옛날 돈카츠"
        chapter2.imageUrl = "https://lh3.googleusercontent.com/proxy/fsdxYWrt5EnXBbsOiW7fqUp8C0tvwYAkiqmMqrBMwduXj442LzEb2apOnJy1KBEI42vJvCV7ykUee2W79izKTYEyBWDINdXHnxrUzsE4zes-JKiwVQ"
        val chapter3 = ChapterMenuTab()
        chapter3.id = 3
        chapter3.chapterName = "등심 돈카츠"
        chapter3.imageUrl = "https://lh3.googleusercontent.com/proxy/X3etdABsbdB8DlCqalRPuIDfOGxYpvtgfNVYBtpbU1dxLd_PGpWOUeYi5Ezrb-tJG9efTNzYcgucLTfW2Z-stXBOFHjq-NZ7ZScRj_Jx3uL1whHfiPI1lih8oBtL-_8zluMwUmJ7uHQ9zZsbsdODrrPS87tgNTuno7Yh44wQwT-9eBwiUvA6IsO8PQ7BAbU"
        physics.chapters!!.add(chapter1)
        physics.chapters!!.add(chapter2)
        physics.chapters!!.add(chapter3)

        val chem = SubjectMenuTab()
        chem.id = 2
        chem.subjectName = "면류"
        chem.chapters = ArrayList<ChapterMenuTab>()
        val chapter6 = ChapterMenuTab()
        chapter6.id = 6
        chapter6.chapterName = "냉메밀 소바"
        chapter6.imageUrl = "http://www.noodlelovers.com/upload_data/m_product_recipe_set/%EB%83%89%EB%A9%94%EB%B0%80.jpg"
        val chapter7 = ChapterMenuTab()
        chapter7.id = 7
        chapter7.chapterName = "Sodium"
        chapter7.imageUrl = "http://ashishkudale.com/images/chem/sodium.png"
        val chapter8 = ChapterMenuTab()
        chapter8.id = 8
        chapter8.chapterName = "Periodic table"
        chapter8.imageUrl = "http://ashishkudale.com/images/chem/periodic_table.png"
        val chapter9 = ChapterMenuTab()
        chapter9.id = 9
        chapter9.chapterName = "Acid and Base"
        chapter9.imageUrl = "http://ashishkudale.com/images/chem/chem.png"
        chem.chapters!!.add(chapter6)
        chem.chapters!!.add(chapter7)
        chem.chapters!!.add(chapter8)
        chem.chapters!!.add(chapter9)
        val bio = SubjectMenuTab()
        bio.id = 3
        bio.subjectName = "입맛 저격! 추천 메뉴"
        bio.chapters = ArrayList<ChapterMenuTab>()
        val chapter10 = ChapterMenuTab()
        chapter10.id = 10
        chapter10.chapterName = "스테이크"
        chapter10.imageUrl = "https://i2.wp.com/www.foodrepublic.com/wp-content/uploads/2012/05/testkitchen_argentinesteak.jpg?resize=1280%2C%20560&ssl=1"
        val chapter11 = ChapterMenuTab()
        chapter11.id = 11
        chapter11.chapterName = "DNA and RNA"
        chapter11.imageUrl = "http://ashishkudale.com/images/bio/dna.png"
        val chapter12 = ChapterMenuTab()
        chapter12.id = 12
        chapter12.chapterName = "Study of microscope"
        chapter12.imageUrl = "http://ashishkudale.com/images/bio/microscope.png"
        val chapter13 = ChapterMenuTab()
        chapter13.id = 13
        chapter13.chapterName = "Protein and fibers"
        chapter13.imageUrl = "http://ashishkudale.com/images/bio/protein.png"
        bio.chapters!!.add(chapter10)
        bio.chapters!!.add(chapter11)
        bio.chapters!!.add(chapter12)
        bio.chapters!!.add(chapter13)
        val maths = SubjectMenuTab()
        maths.id = 4
        maths.subjectName = "저렴한 메뉴"
        maths.chapters = ArrayList<ChapterMenuTab>()
        val chapter14 = ChapterMenuTab()
        chapter14.id = 14
        chapter14.chapterName = "Circle"
        chapter14.imageUrl = "http://ashishkudale.com/images/maths/circle.png"
        val chapter15 = ChapterMenuTab()
        chapter15.id = 15
        chapter15.chapterName = "Geometry"
        chapter15.imageUrl = "http://ashishkudale.com/images/maths/geometry.png"
        val chapter16 = ChapterMenuTab()
        chapter16.id = 16
        chapter16.chapterName = "Linear equations"
        chapter16.imageUrl = "http://ashishkudale.com/images/maths/linear.png"
        val chapter17 = ChapterMenuTab()
        chapter17.id = 17
        chapter17.chapterName = "Graph"
        chapter17.imageUrl = "http://ashishkudale.com/images/maths/plot.png"
        val chapter18 = ChapterMenuTab()
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

    override fun onResume() {
        super.onResume()
        //homeViewModel.getGridItems()
    }
}