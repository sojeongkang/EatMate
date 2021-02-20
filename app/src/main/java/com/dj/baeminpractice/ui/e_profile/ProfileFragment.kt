package com.dj.baeminpractice.ui.e_profile

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.dj.baeminpractice.R
import com.dj.baeminpractice.ui.a_home.MenuTab.MenuActivity
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment: Fragment(R.layout.fragment_profile){

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        button.setOnClickListener {
            activity?.let{
                val intent = Intent(context, MenuActivity::class.java)
                startActivity(intent)
            }
        }
    }


}