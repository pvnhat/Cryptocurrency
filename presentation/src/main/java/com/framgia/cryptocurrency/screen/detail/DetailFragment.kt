package com.framgia.cryptocurrency.screen.detail

import android.annotation.SuppressLint
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.framgia.cryptocurrency.R
import com.framgia.cryptocurrency.base.BaseFragment
import com.framgia.cryptocurrency.di.ViewModelFactory
import com.framgia.domain.entity.MoreCoin
import kotlinx.android.synthetic.main.fragment_detail.*
import java.text.SimpleDateFormat
import javax.inject.Inject

class DetailFragment : BaseFragment(), OnDataReceivedListener {

    companion object {

        val BUNDLE_SYMBOL_KEY = "SYMBOL"

        fun newInstance(symbol: String): DetailFragment {
            val detailFragment = DetailFragment()
            val args = Bundle()
            args.putString(BUNDLE_SYMBOL_KEY, symbol)
            detailFragment.arguments = args
            return detailFragment
        }
    }

    private var mSymbol: String? = null
    lateinit var viewModel: DetailViewModel
    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_detail, container, false)
        viewModel = ViewModelProviders.of(this, this.viewModelFactory).get(DetailViewModel::class.java)
        val mActivity = activity as DetailActivity
        mActivity.setDataReceivedListener(this)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData()
    }

    private fun initData() {
        if (viewModel.moreCoinDetail.value == null && userVisibleHint) {
            viewModel.getCoiDetaiBySymbol(this.mSymbol!!)
            viewModel.moreCoinDetail.observe(this, Observer<MoreCoin> { t: MoreCoin? ->
                if (t != null) {
                    setView(t)
                }
            })
        } else {
            setView(viewModel.moreCoinDetail.value!!)
        }
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        if (isVisibleToUser && isResumed) {
            initData()
        }
    }

    private fun setView(moreCoin: MoreCoin) {
        try {
            progress_load.visibility = View.GONE
            val coinDetailResult = moreCoin.data!!.values.toTypedArray().first()
            coinDetailResult.apply {
                text_symbol.text = symbol.toString()
                text_name.text = name.toString()
                text_circulating.text = circulatingSupply.toString()
                text_total.text = totalSupply.toString()
                text_max.text = maxSupply.toString()
                text_rank.text = cmcRank.toString()
                text_price.text = quote?.usd?.price.toString()
                text_price2.text = quote?.usd?.price.toString()
                text_volume.text = quote?.usd?.volume24h.toString()
                checkChageTime(text_change_1h, quote?.usd?.percentChange1h!!)
                checkChageTime(text_change_24h, quote?.usd?.percentChange24h!!)
                checkChageTime(text_change_7d, quote?.usd?.percentChange7d!!)
                text_marketcap.text = coinDetailResult.quote!!.usd!!.marketCap.toString()
                text_last_update.text = formatTime(coinDetailResult.lastUpdated.toString())
            }
        } catch (e: IndexOutOfBoundsException) {
            Toast.makeText(context, getString(R.string.not_data), Toast.LENGTH_LONG).show()
        } catch (e: NoSuchElementException) {
            Toast.makeText(context, getString(R.string.not_data), Toast.LENGTH_SHORT).show()
        }


    }

    @SuppressLint("SimpleDateFormat")
    private fun formatTime(orginApi: String): String {
        val formatter = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
        val date = formatter.parse(orginApi)
        val outputFormat = SimpleDateFormat("dd/MM/yyyy--hh:MM")
        return outputFormat.format(date)
    }

    @SuppressLint("ResourceAsColor", "SetTextI18n")
    private fun checkChageTime(textView: TextView, value: Double) {
        if (value > 0) {
            textView.setTextColor(ContextCompat.getColor(context!!, R.color.color_green_100))
            textView.text = context!!.getString(R.string.text_plus) + value.toString()
        } else if (value < 0) {
            textView.setTextColor(ContextCompat.getColor(context!!, R.color.color_red_100))
            textView.text = value.toString()
        } else {
            textView.text = value.toString()
        }
    }

    override fun onDataReceived(symbol: String) {
        mSymbol = symbol
    }
}
