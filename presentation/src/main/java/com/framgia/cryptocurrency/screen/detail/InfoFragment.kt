package com.framgia.cryptocurrency.screen.detail

import android.annotation.SuppressLint
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.framgia.cryptocurrency.R
import com.framgia.cryptocurrency.base.BaseFragment
import com.framgia.cryptocurrency.di.ViewModelFactory
import com.framgia.domain.entity.MoreCoinInfo
import kotlinx.android.synthetic.main.fragment_info.*
import java.text.SimpleDateFormat
import javax.inject.Inject

class InfoFragment : BaseFragment(), OnDataReceivedListener, View.OnClickListener {

    private var mSymbol: String? = null
    lateinit var viewModel: InfoViewModel
    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_info, container, false)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(InfoViewModel::class.java)
        (activity as DetailActivity).setDataReceivedListener(this)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (userVisibleHint) {
            initData()
        }
    }

    private fun initData() {
        if (viewModel.moreCoinInfo.value == null) { // if -> is it visibile to user
            viewModel.getCoiInfoBySymbol(this.mSymbol!!)
            viewModel.getLiveMoreCoiInfo().observe(this, Observer<MoreCoinInfo> { t: MoreCoinInfo? ->
                if (t != null) {
                    setView(t)
                }
            })
        } else {
            setView(viewModel.moreCoinInfo.value!!)
        }
    }

    private fun setView(moreCoinInfo: MoreCoinInfo) {
        try {

            progress_load.visibility = View.GONE
            text_home.setOnClickListener(this)
            text_twitter.setOnClickListener(this)
            text_reddit.setOnClickListener(this)
            text_message.setOnClickListener(this)
            text_explore.setOnClickListener(this)
            val coinInfoResult = moreCoinInfo.data?.values?.toTypedArray()?.first()
            loadImage(image_coin, coinInfoResult?.logo!!)
            coinInfoResult.apply {
                text_name.text = name
                text_id.text = id.toString()
                text_category.text = category
                text_date.text = formatTime(dateAdded!!)
                text_home.text = urls?.website?.first()
                text_twitter.text = urls?.twitter?.first() as CharSequence?
                text_reddit.text = urls?.reddit?.first()
                text_explore.text = urls?.explorer?.first()
                text_message.text = urls?.messageBoard?.first()
            }

        } catch (e: IndexOutOfBoundsException) {
            Toast.makeText(context, getString(R.string.not_data), Toast.LENGTH_SHORT).show()
        } catch (e: NoSuchElementException) {
            Toast.makeText(context, getString(R.string.not_data), Toast.LENGTH_SHORT).show()
        }
    }

    // set action when fragmen visible
    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        if (isVisibleToUser && isResumed) {
            initData()
        }
    }

    @SuppressLint("SimpleDateFormat")
    private fun formatTime(orginApi: String): String {
        val formatter = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
        val date = formatter.parse(orginApi)
        val outputFormat = SimpleDateFormat("dd/MM/yyyy--hh:MM")
        return outputFormat.format(date)
    }

    private fun loadImage(imageView: ImageView, symbol: String) {
        Glide.with(imageView.context).setDefaultRequestOptions(
                RequestOptions().centerCrop().placeholder(R.drawable.ic_loading).error(
                        R.drawable.ic_empty)
        ).load(symbol).into(imageView)
    }

    private fun onOpenBrower(textView: TextView) {
        if (textView.text != null) {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.setData(Uri.parse(textView.text.trim() as String))
            startActivity(intent)
        } else {
            Toast.makeText(context, getString(R.string.not_data), Toast.LENGTH_SHORT).show()
        }
    }

    override fun onClick(p0: View?) {
        when (p0) {
            text_home -> onOpenBrower(text_home)
            text_twitter -> onOpenBrower(text_twitter)
            text_reddit -> onOpenBrower(text_reddit)
            text_message -> onOpenBrower(text_message)
            text_explore -> onOpenBrower(text_explore)
        }
    }

    override fun onDataReceived(symbol: String) {
        mSymbol = symbol
    }
}
