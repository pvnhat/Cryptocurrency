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

        private val INTENT_KEY_SYMBOL = "symbol"

        fun newInstance(context: Context, symbol: String): Intent {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(INTENT_KEY_SYMBOL, symbol)
            return intent
        }
    }

    private var mSymbol: String? = null
    private var mOnDataReceivedListener: OnDataReceivedListener? = null

    fun setDataReceivedListener(onDataReceivedListener: OnDataReceivedListener) {
        mOnDataReceivedListener = onDataReceivedListener
        mOnDataReceivedListener?.onDataReceived(this.mSymbol!!)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        getData()
        initView()
    }

    private fun getData() {
        val dataString = intent.getStringExtra(INTENT_KEY_SYMBOL)
        supportActionBar!!.setTitle(dataString)
        mSymbol = dataString
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
