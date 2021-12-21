package com.pinit.kotlinproject.Fragments
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.pinit.kotlinproject.R


class Home_bottom : Fragment() {

    override fun onCreateView(



        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment_home_bottom, container, false)


        val tabLayout = view?.findViewById<TabLayout>(R.id.tabLayout_homebottom)
        val viewPager = view?.findViewById<ViewPager>(R.id.viewPager_homebottom)


        if (viewPager != null) {
            setupViewPager(viewPager)
        }


        tabLayout!!.setupWithViewPager(viewPager)
        return view

    }

    private fun setupViewPager(viewPager: ViewPager) {
        val adapter = ViewPagerAdapter(childFragmentManager)
        adapter.addFragment(First(),"first")
        adapter.addFragment(Second(), "second")

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

    }

}





