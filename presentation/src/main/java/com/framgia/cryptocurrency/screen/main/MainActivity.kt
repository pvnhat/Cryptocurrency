package com.framgia.cryptocurrency.screen.main

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.framgia.cryptocurrency.R
import com.framgia.cryptocurrency.base.BaseActivity
import com.framgia.cryptocurrency.di.ViewModelFactory
import com.framgia.cryptocurrency.screen.detail.DetailActivity
import com.framgia.domain.entity.CoinDetailResult
import com.framgia.domain.entity.MoreCoinDetail
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import javax.inject.Inject

class MainActivity : BaseActivity(), NavigationView.OnNavigationItemSelectedListener, OnItemClick {
    override fun onItemClicked(coinId: Int) {
        Toast.makeText(this, "Item click: " + coinId, Toast.LENGTH_SHORT).show()
        startActivity(DetailActivity.newInstance(this))
    }

    override fun onFavoriteClicked(coinId: Int) {
        Toast.makeText(this, "Add Favorite: " + coinId, Toast.LENGTH_SHORT).show()
    }

    private lateinit var mToggle: ActionBarDrawerToggle
    lateinit var viewModel: MainViewModel
    @Inject
    lateinit var viewModelFactory: ViewModelFactory


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()

        initData()
    }

    private fun initData() {
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.getLatestCoin()
        registerLiveDataListenner()
    }

    private fun registerLiveDataListenner() {
        val listCoinAdapter = ListCoinAdapter2()
        listCoinAdapter.onItemClick = this
        recycler_coin_list.adapter = listCoinAdapter
        viewModel.getMoreCoiDetail().observe(this, Observer<MoreCoinDetail> { t: MoreCoinDetail? ->
            if (t != null) {
                listCoinAdapter.onUpdateAdapter(t.listCoin as MutableList<CoinDetailResult>)
                progress_load.visibility = View.GONE
            }
        })
    }

    private fun initView() {
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
}
