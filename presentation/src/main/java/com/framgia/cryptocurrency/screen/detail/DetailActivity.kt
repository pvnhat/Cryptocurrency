package com.framgia.cryptocurrency.screen.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.framgia.cryptocurrency.R
import com.framgia.cryptocurrency.base.BaseActivity
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : BaseActivity() {

    companion object {

        private const val INTENT_KEY_SYMBOL = "symbol"

        fun newInstance(context: Context, symbol: String): Intent {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(INTENT_KEY_SYMBOL, symbol)
            return intent
        }
    }

    private var mSymbol: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        getData()
        initView()
    }

    private fun getData() {
        val dataString = intent.getStringExtra(INTENT_KEY_SYMBOL)
        supportActionBar?.title = dataString
        mSymbol = dataString
    }

    private fun initView() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val fragmentManager = supportFragmentManager
        val viewPagerAdapter = ViewPagerAdapter(fragmentManager, mSymbol ?: "")
        viewpager_detail.adapter = viewPagerAdapter
        tab_detail.setupWithViewPager(viewpager_detail, true)
        tab_detail.setTabsFromPagerAdapter(viewPagerAdapter)

        // using when set event when click tab item
        //tab_detail.addOnTabSelectedListener(TabLayout.ViewPagerOnTabSelectedListener(viewpager_detail))

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
