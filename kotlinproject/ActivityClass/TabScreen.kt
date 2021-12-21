package com.pinit.kotlinproject.ActivityClass
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.pinit.kotlinproject.Fragments.Home
import com.pinit.kotlinproject.Fragments.Movie
import com.pinit.kotlinproject.Fragments.Sporst
import com.pinit.kotlinproject.R

class TabScreen : AppCompatActivity() {

    //var tabLayout: TabLayout? = null
  //  var viewPager: ViewPager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tab_activity)

       val tabLayout = findViewById<TabLayout>(R.id.tabLayout_1)
       val viewPager = findViewById<ViewPager>(R.id.viewPager_11)
        setupViewPager(viewPager)
        tabLayout!!.setupWithViewPager(viewPager)

    }
    private fun setupViewPager(viewPager: ViewPager) {
            val adapter = ViewPagerAdapter(supportFragmentManager)
            adapter.addFragment(Home(),"Home")
            adapter.addFragment(Movie(), "About Us")
            adapter.addFragment(Sporst(), "Contact Us")
            viewPager.adapter = adapter
        }

      inner class ViewPagerAdapter(manager: FragmentManager) : FragmentPagerAdapter(manager) {
            private val mFragmentList = ArrayList<Fragment>()
            private val mFragmentTitleList = ArrayList<String>()

            override fun getItem(position: Int): Fragment {
                return mFragmentList[position]
            }

            override fun getCount(): Int {
                return mFragmentList.size
            }

            fun addFragment(fragment: Fragment, title: String) {
                mFragmentList.add(fragment)
                mFragmentTitleList.add(title)
            }

            override fun getPageTitle(position: Int): CharSequence {
                return mFragmentTitleList[position]
            }

        }      }
