package com.framgia.cryptocurrency.screen.main

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.framgia.cryptocurrency.R
import com.framgia.cryptocurrency.base.BaseActivity
import com.framgia.cryptocurrency.di.ViewModelFactory
import com.framgia.cryptocurrency.screen.detail.DetailActivity
import com.framgia.cryptocurrency.utils.Constants
import com.framgia.domain.entity.CoinDetailResult
import com.framgia.domain.entity.MoreCoinDetail
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import javax.inject.Inject

class MainActivity : BaseActivity(), NavigationView.OnNavigationItemSelectedListener, OnItemClick, SwipeRefreshLayout.OnRefreshListener {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private lateinit var mToggle: ActionBarDrawerToggle
    lateinit var viewModel: MainViewModel
    private var mListCoinAdapter: ListCoinAdapter2? = null
    private var mCurrentItem: Int = 0
    private var mTotalItem: Int = 0
    private var mScrollOutItem: Int = 0
    private var mIsScrolling: Boolean = false
    private var mStartNum = Constants.NUM_20

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java)
        initData()
    }


    private fun initData() {
        registerLiveDataListenner()
        loadMoreRecycler()
        onSwipRefresh()
        mListCoinAdapter = ListCoinAdapter2()
        mListCoinAdapter?.onItemClick = this
        recycler_coin_list.adapter = mListCoinAdapter
    }

    private fun onSwipRefresh() {
        swipe_layout.setOnRefreshListener(this)
    }

    private fun loadMoreRecycler() {
        recycler_coin_list.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                mCurrentItem = recyclerView!!.childCount
                mTotalItem = recyclerView.layoutManager.itemCount
                mScrollOutItem = (recyclerView.layoutManager as LinearLayoutManager).findFirstVisibleItemPosition()
                if (!mIsScrolling && mCurrentItem + mScrollOutItem == mTotalItem) {
                    mStartNum += Constants.NUM_20
                    mIsScrolling = false
                    progress_load_more.visibility = View.VISIBLE
                    viewModel.getLatestCoin(mStartNum)
                }

            }
        })
    }

    private fun registerLiveDataListenner() {
        if (viewModel.moreCoinDetail.value == null) {
            viewModel.getLatestCoin(Constants.NUM_20)
            viewModel.getMoreCoiDetail().observe(this, Observer<MoreCoinDetail> { t: MoreCoinDetail? ->
                if (t != null) {
                    initView(t)
                }
            })
        } else {
            initView(viewModel.moreCoinDetail.value!!)
        }
    }

    private fun initView(moreCoinDetail: MoreCoinDetail) {
        progress_load.visibility = View.GONE
        if (progress_load_more.visibility != View.GONE) {
            progress_load_more.visibility = View.GONE
        }

        onLoadDataToList(moreCoinDetail)

        text_date.text = Calendar.getInstance().time.toString()
        mToggle = ActionBarDrawerToggle(
                this, drawer_layout, R.string.navigation_drawer_open,
                R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(mToggle)
        mToggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)
        nav_view.setNavigationItemSelectedListener(this)
    }

    private fun onLoadDataToList(moreCoinDetail: MoreCoinDetail) {
        if (mStartNum == Constants.NUM_20) {
            mListCoinAdapter?.onUpdateAdapter(moreCoinDetail.listCoin as MutableList<CoinDetailResult>)

        } else {
            mListCoinAdapter?.onLoadMore(moreCoinDetail.listCoin as MutableList<CoinDetailResult>)
        }
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (mToggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_camera -> {

            }
            R.id.nav_gallery -> {

            }
            R.id.nav_slideshow -> {

            }
            R.id.nav_manage -> {

            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onRefresh() {
        registerLiveDataListenner()
        swipe_layout.isRefreshing = false
    }

    override fun onItemClicked(symbol: String) {
        startActivity(DetailActivity.newInstance(this, symbol))
    }

    override fun onFavoriteClicked(symbol: String) {
        Toast.makeText(this, "Add Favorite: " + symbol, Toast.LENGTH_SHORT).show()
    }
}

