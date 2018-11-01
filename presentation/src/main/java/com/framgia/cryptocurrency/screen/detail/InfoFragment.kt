package com.framgia.cryptocurrency.screen.detail

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.framgia.cryptocurrency.R
import com.framgia.cryptocurrency.base.BaseFragment
import com.framgia.cryptocurrency.di.ViewModelFactory
import com.framgia.domain.entity.MoreCoinInfo
import javax.inject.Inject

class InfoFragment : BaseFragment() {

    lateinit var viewModel: InFoViewModel
    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_info, container, false)

        if (userVisibleHint) { // if -> is it visibile to user
            initData()
        }
        return view
    }

    private fun initData() {
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(InFoViewModel::class.java)
        viewModel.getCoiInfoBySymbol("PAX")
        viewModel.getLiveMoreCoiInfo().observe(this, Observer<MoreCoinInfo> { t: MoreCoinInfo? ->
            println("info : " + t?.data!!.values.toTypedArray().get(0).logo)
        })

    }

    // set action when fragmen visible
    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        if (isVisibleToUser && isResumed) {
            initData()
        }
    }
}
