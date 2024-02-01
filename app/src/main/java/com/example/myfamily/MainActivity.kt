package com.example.myfamily

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.coroutines.selects.SelectInstance

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_activity)
        val bottombar=findViewById<BottomNavigationView>(R.id.bottom_bar)
        bottombar.setOnItemSelectedListener {menuitem->

            if(menuitem.itemId == R.id.nav_guard) {
                inflateFragment(GuardFragment.newInstance())
            }else if(menuitem.itemId == R.id.nav_home) {
                inflateFragment(HomeFragment.newInstance())
            }else if(menuitem.itemId == R.id.nav_dashboard) {
                inflateFragment(DashboardFragment.newInstance())
            }else if(menuitem.itemId == R.id.nav_profile) {
                inflateFragment(ProfileFragment.newInstance())
            }
            true

        }
    }

    private fun inflateFragment(newInstance: Fragment) {
        val transaction=supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container,newInstance)
        transaction.commit()
    }
}