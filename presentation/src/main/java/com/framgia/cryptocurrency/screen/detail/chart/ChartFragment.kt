package com.framgia.cryptocurrency.screen.detail.chart

import android.annotation.SuppressLint
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.framgia.cryptocurrency.R
import com.framgia.cryptocurrency.base.BaseFragment
import com.framgia.cryptocurrency.di.ViewModelFactory
import com.framgia.cryptocurrency.utils.Const
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import kotlinx.android.synthetic.main.fragment_chart.*
import javax.inject.Inject

class ChartFragment : BaseFragment() {

  private var mSymbol: String? = null
  private lateinit var viewModel: ChartViewModel
  @Inject
  lateinit var viewModelFactory: ViewModelFactory

  companion object {

    private const val BUNDLE_SYMBOL_KEY = "SYMBOL"

    fun newInstance(symbol: String): ChartFragment {
      val chartFragment = ChartFragment()
      val args = Bundle()
      args.putString(BUNDLE_SYMBOL_KEY, symbol)
      chartFragment.arguments = args
      return chartFragment
    }
  }

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
      savedInstanceState: Bundle?): View? {
    viewModel = ViewModelProviders.of(this, this.viewModelFactory).get(ChartViewModel::class.java)
    return inflater.inflate(R.layout.fragment_chart, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    initView()
  }

  @SuppressLint("ResourceAsColor")
  private fun initView() {
    progress_loading.visibility = View.GONE

    mSymbol = arguments?.getString(ChartFragment.BUNDLE_SYMBOL_KEY)
    viewModel.getCoinPrices1d(mSymbol ?: "", Const.NUM_24h)
    btn_24h.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.color_amber_700))

    btn_24h.setOnClickListener {
      linechart.visibility = View.GONE
      progress_loading.visibility = View.VISIBLE
      btn_24h.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.color_amber_700))
      btn_7d.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.color_grey_500))
      btn_30d.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.color_grey_500))
      viewModel.getCoinPrices1d(mSymbol ?: "", Const.NUM_24h)
    }
    btn_7d.setOnClickListener {
      linechart.visibility = View.GONE
      progress_loading.visibility = View.VISIBLE
      btn_24h.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.color_grey_500))
      btn_7d.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.color_amber_700))
      btn_30d.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.color_grey_500))
      viewModel.getCoinPrices7d(mSymbol ?: "", Const.NUM_7d)
    }
    btn_30d.setOnClickListener {
      linechart.visibility = View.GONE
      progress_loading.visibility = View.VISIBLE
      btn_24h.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.color_grey_500))
      btn_7d.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.color_grey_500))
      btn_30d.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.color_amber_700))
      viewModel.getCoinPrices30d(mSymbol ?: "", Const.NUM_30d)
    }

    observe()
  }

  private fun observe() {
    viewModel.coiPrices.observe(this, Observer { t: List<Float>? ->
      if (t != null) {
        progress_loading.visibility = View.GONE
        fillDataChart(t)
      }
    })
  }

  private fun fillDataChart(listData: List<Float> = emptyList()) {
    linechart.visibility = View.VISIBLE
    linechart.setScaleEnabled(true)
    val listEntry = mutableListOf<Entry>()
    for (i in 0 until listData.size step 1) {
      listEntry.add(Entry(i.toFloat(), listData[i]))
    }

    val lineDataSet = LineDataSet(listEntry, "Coin Price (USD)")
    lineDataSet.fillAlpha = 110
    val dataSet: MutableList<ILineDataSet> = mutableListOf()
    dataSet.add(lineDataSet)
    val lineData = LineData(dataSet)
    linechart.data = lineData
  }
}
