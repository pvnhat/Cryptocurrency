package com.framgia.cryptocurrency.screen.detail

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.framgia.cryptocurrency.R
import com.framgia.cryptocurrency.base.BaseFragment
import com.framgia.cryptocurrency.di.ViewModelFactory
import com.framgia.domain.entity.MoreCoin
import javax.inject.Inject

class DetailFragment : BaseFragment() {

    lateinit var viewModel: DetailViewModel
    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_detail, container, false)

        if (userVisibleHint) {
            initData(this.context!!)
        }

        return view
    }

    private fun initData(context: Context) {
        viewModel = ViewModelProviders.of(this, this.viewModelFactory).get(DetailViewModel::class.java)
        viewModel.getCoiDetaiBySymbol("PAX")
        viewModel.getMoreCoinBySymbol().observe(this, Observer<MoreCoin> { t: MoreCoin? ->
            println("detail : " + t?.data?.values?.toTypedArray()?.get(t?.data?.values?.size!! - 1)?.quote?.usd?.price.toString())
        })
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        if (isVisibleToUser && isResumed) {
            initData(this.context!!)
        }
    }
}
