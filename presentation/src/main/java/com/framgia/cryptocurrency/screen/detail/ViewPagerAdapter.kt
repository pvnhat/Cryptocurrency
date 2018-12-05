package com.framgia.cryptocurrency.screen.detail

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.framgia.cryptocurrency.screen.detail.chart.ChartFragment
import com.framgia.cryptocurrency.screen.detail.coin.DetailFragment
import com.framgia.cryptocurrency.screen.detail.info.InfoFragment

class ViewPagerAdapter(fragmentManager: FragmentManager, private var symbol: String) : FragmentStatePagerAdapter(fragmentManager) {
    companion object {
        private const val DETAIL_FRAGMENT_TITLE = "Detail"
        private const val INFO_FRAGMENT_TITLE = "Info"
        private const val CHART_FRAGMENT_TITLE = "Chart"
    }

    override fun getItem(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment = DetailFragment.newInstance(symbol)
            1 -> fragment = InfoFragment.newInstance(symbol)
            2 -> fragment = ChartFragment.newInstance(symbol)
        }
        return fragment!!
    }

    override fun getCount(): Int {
        return 3
    }

    override fun getPageTitle(position: Int): CharSequence? {
        var title: String? = null
        when (position) {
            0 -> title = DETAIL_FRAGMENT_TITLE
            1 -> title = INFO_FRAGMENT_TITLE
            2 -> title = CHART_FRAGMENT_TITLE
        }
        return title
    }

}
