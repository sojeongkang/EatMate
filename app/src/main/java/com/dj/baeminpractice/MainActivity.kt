package com.dj.baeminpractice

import android.net.sip.SipManager.newInstance
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.navigation.NavController
import com.dj.baeminpractice.ui.a_home.RecruitFragment
import com.dj.baeminpractice.ui.a_home.RoomFragment
import com.dj.baeminpractice.ui.d_community.CommunityFragment

import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.lang.reflect.Array.newInstance
import javax.xml.datatype.DatatypeFactory.newInstance
import javax.xml.transform.TransformerFactory.newInstance


class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var bottomNavigationView: BottomNavigationView
    private var currentNavController: LiveData<NavController> ?= null

    lateinit var fab_open: Animation
    lateinit var fab_close:Animation
    lateinit var fab_main: FloatingActionButton
    lateinit var fab1:FloatingActionButton
    lateinit var fab2:FloatingActionButton
    var openFlag = false

    lateinit var frag1:RoomFragment
    lateinit var frag2:RecruitFragment
    lateinit var frag3:CommunityFragment


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if(savedInstanceState == null){
            setUpBottomNavigationBar()
        }

        fab_open = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_open)
        fab_close = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_close)

        fab_main = findViewById(R.id.fab_main)
        fab1 = findViewById(R.id.fab1)
        fab2 = findViewById(R.id.fab2)

        //버튼 상태 초기화(닫혀있도록)
        fab1.startAnimation(fab_close)
        fab2.startAnimation(fab_close)
        fab1.setClickable(false)
        fab2.setClickable(false)

        fab_main.setOnClickListener(this)
        fab1.setOnClickListener(this)
        fab2.setOnClickListener(this)

        //val fragmentTransaction = getSupportFragmentManager().beginTransaction()
        //fragmentTransaction.add(R.id.action_container, CommunityFragment()).commit()

        val frag1 = RoomFragment() //프래그먼트 객채셍성
        val frag2 = RecruitFragment() //프래그먼트 객채셍성
        val frag3 = CommunityFragment() //프래그먼트 객채셍성
        //setFrag(0) //프래그먼트 교체
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        setUpBottomNavigationBar()
    }

    private fun setUpBottomNavigationBar(){
        bottomNavigationView = findViewById(R.id.bottom_nav)

        val navGraphIds = listOf(
            R.navigation.nav_home,
            R.navigation.nav_eat_what,
            R.navigation.nav_favorite,
            R.navigation.nav_order,
            R.navigation.nav_profile
        )
        val controller = bottomNavigationView.setupWithNavController(
            navGraphIds, supportFragmentManager, R.id.nav_host_fragment_container, intent
        )
        currentNavController = controller
    }

    fun anim() {
        if (openFlag)
        {
            fab1.startAnimation(fab_close)
            fab2.startAnimation(fab_close)
            fab1.setClickable(false)
            fab2.setClickable(false)
            openFlag = false
        }
        else
        {
            fab1.startAnimation(fab_open)
            fab2.startAnimation(fab_open)
            fab1.setClickable(true)
            fab2.setClickable(true)
            openFlag = true
        }
    }
    override fun onClick(v: View) {
        val id = v.getId()
        when (id) {
            R.id.fab_main -> anim()
            R.id.fab1 -> {
                anim()
                Toast.makeText(this, "노랑이", Toast.LENGTH_SHORT).show()
            }
            R.id.fab2 -> {
                anim()
                Toast.makeText(this, "파랑이", Toast.LENGTH_SHORT).show()
            }
        }
    }

    /*
    //프래그먼트가 바뀔때 작동하게끔 작성한 메서드
    fun onFragmentChange() {
        //프래그먼트의 번호에 따라 다르게 작동하는 조건문
        //if (fragmentNum == 1) {
            supportFragmentManager.beginTransaction().replace(R.id.action_container, orderFragment
            )
                .commit()
       // } else if (fragmentNum == 2) {
        //    supportFragmentManager.beginTransaction().replace(R.id.action_container, mainFragment)
       //         .commit()
      //  }
    }

     */

    fun replaceFragment(fragment: Fragment) {
        val fragmentManager = getSupportFragmentManager()
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.action_container, fragment).commit() // Fragment로 사용할 MainActivity내의 layout공간을 선택합니다.
    }



}