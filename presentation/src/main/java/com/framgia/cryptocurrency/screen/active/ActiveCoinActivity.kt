package com.framgia.cryptocurrency.screen.active

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.SearchView
import android.widget.Toast
import com.framgia.cryptocurrency.R
import com.framgia.cryptocurrency.base.BaseActivity
import com.framgia.cryptocurrency.di.ViewModelFactory
import com.framgia.cryptocurrency.screen.detail.DetailActivity
import com.framgia.cryptocurrency.screen.main.MainViewModel
import com.framgia.cryptocurrency.utils.Const
import com.framgia.domain.entity.CoinDetailResult
import com.framgia.domain.entity.MoreCoinDetail
import kotlinx.android.synthetic.main.activity_active_coin.*
import javax.inject.Inject

class ActiveCoinActivity : BaseActivity(), SwipeRefreshLayout.OnRefreshListener, SearchView.OnQueryTextListener {

  @Inject
  lateinit var viewModelFactory: ViewModelFactory
  lateinit var viewModel: MainViewModel
  private lateinit var mListCoinAdapter: ActiveCoinAdapter
  private var mCurrentItem: Int = 0
  private var mTotalItem: Int = 0
  private var mScrollOutItem: Int = 0
  private var mIsScrolling: Boolean = false
  private var mStartNum = Const.NUM_20
  private lateinit var mSearchView: SearchView

  companion object {
    fun newInstance(context: Context): Intent {
      return Intent(context, ActiveCoinActivity::class.java)
    }
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_active_coin)
    viewModel = ViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java)
    initView()
    initData()

  }

  private fun initView() {
    supportActionBar?.setDisplayHomeAsUpEnabled(true)
    supportActionBar?.setHomeButtonEnabled(true)
    recycler_coin_list.layoutManager = GridLayoutManager(this, 3)
  }


  private fun initData() {
    initClick()
    registerLiveDataListenner()
    loadMoreRecycler()
    onSwipRefresh()
    recycler_coin_list.adapter = mListCoinAdapter
  }

  private fun initClick() {
    mListCoinAdapter = ActiveCoinAdapter({ symbol ->
      startActivity(DetailActivity.newInstance(this, symbol))
    }, {
      Toast.makeText(this, "Add Favorite: " + it, Toast.LENGTH_SHORT).show()
    })
  }

  private fun onSwipRefresh() {
    swipe_layout.setOnRefreshListener(this)
  }

  override fun onSupportNavigateUp(): Boolean {
    onBackPressed()
    return super.onSupportNavigateUp()
  }

  private fun loadMoreRecycler() {
    recycler_coin_list.addOnScrollListener(object : RecyclerView.OnScrollListener() {
      override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)
        mCurrentItem = recyclerView!!.childCount
        mTotalItem = recyclerView.layoutManager.itemCount
        mScrollOutItem = (recyclerView.layoutManager as LinearLayoutManager).findFirstVisibleItemPosition()
        if (!mIsScrolling && mCurrentItem + mScrollOutItem == mTotalItem) {
          mStartNum += Const.NUM_20
          mIsScrolling = false
          progress_load_more.visibility = View.VISIBLE
          viewModel.getLatestCoin(mStartNum)
        }

      }
    })
  }


  private fun registerLiveDataListenner() {
    if (viewModel.moreCoinDetail.value == null) {
      viewModel.getLatestCoin(Const.NUM_20)
      viewModel.getMoreCoiDetail().observe(this, Observer<MoreCoinDetail> { t: MoreCoinDetail? ->
        if (t != null) {
          setView(t)
        }
      })
    } else {
      setView(viewModel.moreCoinDetail.value!!)
    }
  }

  private fun setView(moreCoinDetail: MoreCoinDetail) {
    progress_load.visibility = View.GONE
    if (progress_load_more.visibility != View.GONE) {
      progress_load_more.visibility = View.GONE
    }

    onLoadDataToList(moreCoinDetail)
  }

  private fun onLoadDataToList(moreCoinDetail: MoreCoinDetail) {
    if (mStartNum == Const.NUM_20) {
      mListCoinAdapter.onUpdateAdapter(moreCoinDetail.listCoin as MutableList<CoinDetailResult>)

    } else {
      mListCoinAdapter.onLoadMore(moreCoinDetail.listCoin as MutableList<CoinDetailResult>)
    }
  }

  override fun onRefresh() {
    registerLiveDataListenner()
    swipe_layout.isRefreshing = false
  }

  override fun onQueryTextSubmit(keyword: String?): Boolean {
    mSearchView.setQuery("", false)
    mSearchView.isIconified = true
    if (keyword == null || keyword == "") {
      Toast.makeText(this, getString(R.string.enterkey), Toast.LENGTH_SHORT).show()
    } else {
      startActivity(DetailActivity.newInstance(this, keyword.toUpperCase()))
    }
    return true
  }

  override fun onQueryTextChange(p0: String?): Boolean {
    return false
  }
}
