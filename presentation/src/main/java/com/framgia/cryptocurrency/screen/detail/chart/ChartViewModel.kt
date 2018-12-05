package com.framgia.cryptocurrency.screen.detail.chart

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.framgia.cryptocurrency.utils.Const
import com.framgia.domain.entity.MoreCoin
import com.framgia.domain.interactor.GetCoinDetail
import io.reactivex.observers.DisposableObserver
import java.util.*
import javax.inject.Inject

class ChartViewModel @Inject constructor(private val getCoinDetail: GetCoinDetail) : ViewModel() {

  var coiPrices = MutableLiveData<List<Float>>()

  fun getCoinPrices1d(symbol: String, type: Int = 0) {
    getCoinDetail.execute(object : DisposableObserver<MoreCoin>() {
      override fun onComplete() {
      }

      override fun onNext(t: MoreCoin) {
        val price = t.data?.values?.toTypedArray()?.first()?.quote?.usd?.price?.toFloat()
        coiPrices.value = price?.let { getRandomPrice(it, type) }
      }

      override fun onError(e: Throwable) {
        Log.d("error : ", e.message.toString())
      }
    }, symbol)
  }

  fun getCoinPrices7d(symbol: String, type: Int = 0) {
    getCoinDetail.execute(object : DisposableObserver<MoreCoin>() {
      override fun onComplete() {
      }

      override fun onNext(t: MoreCoin) {
        val price = t.data?.values?.toTypedArray()?.first()?.quote?.usd?.price?.toFloat()
        coiPrices.value = price?.let { getRandomPrice(it, type) }
      }

      override fun onError(e: Throwable) {
        Log.d("error : ", e.message.toString())
      }
    }, symbol)
  }

  fun getCoinPrices30d(symbol: String, type: Int = 0) {
    getCoinDetail.execute(object : DisposableObserver<MoreCoin>() {
      override fun onComplete() {
      }

      override fun onNext(t: MoreCoin) {
        val price = t.data?.values?.toTypedArray()?.first()?.quote?.usd?.price?.toFloat()
        coiPrices.value = price?.let { getRandomPrice(it, type) }
      }

      override fun onError(e: Throwable) {
        Log.d("error : ", e.message.toString())
      }
    }, symbol)
  }


  private fun getRandomPrice(origin: Float, typeNum: Int): List<Float> {
    var multiplier = 0f
    when (typeNum) {
      Const.NUM_24h -> multiplier = 0.07f
      Const.NUM_7d -> multiplier = 0.08f
      Const.NUM_30d -> multiplier = 0.12f
    }
    Log.d("hehe", multiplier.toString())
    val lowest = origin - (origin * multiplier)
    val highest = origin + (origin * multiplier)
    val random = Random()
    val arrPrices = mutableListOf<Float>()
    for (i in 0 until typeNum) {
      arrPrices.add((lowest + random.nextFloat() * (highest - lowest)).toFloat())
    }
    return arrPrices
  }
}