package com.framgia.cryptocurrency.screen.detail

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter

class ViewPagerAdapter(fragmentManager: FragmentManager) : FragmentStatePagerAdapter(fragmentManager) {
    companion object {
        private val DETAIL_FRAGMENT_TITLE = "Detail"
        private val INFO_FRAGMENT_TITLE = "Information Site"
    }

    override fun getItem(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment = DetailFragment()
            1 -> fragment = InfoFragment()
        }
        return fragment!!
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence? {
        var title: String? = null
        when (position) {
            0 -> title = DETAIL_FRAGMENT_TITLE
            1 -> title = INFO_FRAGMENT_TITLE
        }
        return title
    }

}
