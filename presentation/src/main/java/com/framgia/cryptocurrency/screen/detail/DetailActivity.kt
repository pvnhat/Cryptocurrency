package com.framgia.cryptocurrency.screen.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.TabLayout
import com.framgia.cryptocurrency.R
import com.framgia.cryptocurrency.base.BaseActivity
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : BaseActivity() {

    companion object {
        fun newInstance(context: Context): Intent {
            val intent = Intent(context, DetailActivity::class.java)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        initView()
    }

    private fun initView() {
        val fragmentManager = supportFragmentManager
        val viewPagerAdapter = ViewPagerAdapter(fragmentManager)
        viewpager_detail.adapter = viewPagerAdapter
        tab_detail.setupWithViewPager(viewpager_detail, true)
        tab_detail.setTabsFromPagerAdapter(viewPagerAdapter)
        tab_detail.addOnTabSelectedListener(TabLayout.ViewPagerOnTabSelectedListener(viewpager_detail))
    }

}
