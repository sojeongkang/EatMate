package com.dj.baeminpractice

import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.navigation.NavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var bottomNavigationView: BottomNavigationView
    private var currentNavController: LiveData<NavController> ?= null

    lateinit var fab_open: Animation
    lateinit var fab_close:Animation
    lateinit var fab_main: FloatingActionButton
    lateinit var fab1:FloatingActionButton
    lateinit var fab2:FloatingActionButton
    var openFlag = false

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

        //버튼 상태 초기화(닫혀있어라!)
        fab1.startAnimation(fab_close)
        fab2.startAnimation(fab_close)
        fab1.setClickable(false)
        fab2.setClickable(false)

        fab_main.setOnClickListener(this)
        fab1.setOnClickListener(this)
        fab2.setOnClickListener(this)


        /*
        val fab: View = findViewById(R.id.fab_main)
        fab.setOnClickListener { view ->

            Snackbar.make(view, "fab1", Snackbar.LENGTH_LONG)
                .setAction("Action", null)
                .show()
        }

        val fab1: View = findViewById(R.id.fab1)
        fab1.setOnClickListener { view ->


            Snackbar.make(view, "fab2", Snackbar.LENGTH_LONG)
                .setAction("Action", null)
                .show()
        }

         */


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






    /*
    fun onCreate(savedInstanceState:Bundle) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)

        fab_open = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_open)
        fab_close = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_close)
        fab = findViewById(R.id.fab)
        fab2 = findViewById(R.id.fab2)
        fab3 = findViewById(R.id.fab3)
        //버튼 상태 초기화(닫혀있어라!)
        fab2.startAnimation(fab_close)
        fab3.startAnimation(fab_close)
        fab2.setClickable(false)
        fab3.setClickable(false)
        fab.setOnClickListener(this)
        fab2.setOnClickListener(this)
        fab3.setOnClickListener(this)
    }

     */
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
    override fun onClick(v:View) {
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



}