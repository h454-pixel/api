package com.pinit.kotlinproject.ActivityClass
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.fragment.app.Fragment
import com.pinit.kotlinproject.Fragments.Dashboard_bottom
import com.pinit.kotlinproject.Fragments.Home_bottom
import com.pinit.kotlinproject.Fragments.notification_bottom
import com.pinit.kotlinproject.R


class BottomScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_screen)

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNav.setOnNavigationItemSelectedListener(navListener)

        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, Home_bottom()).commit()
    }


    private val navListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item -> // By using switch we can easily get
            // the selected fragment
            // by using there id.
            var selectedFragment: Fragment? = null
            when (item.itemId) {
                R.id.navigation_home -> selectedFragment = Home_bottom()
                R.id.navigation_dashboard -> selectedFragment = Dashboard_bottom()
                R.id.navigation_notifications -> selectedFragment = notification_bottom()
            }
            // It will help to replace the
            // one fragment to other.
            if (selectedFragment != null) {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, selectedFragment)
                    .commit()
            }
            true
        }
}