package com.framgia.cryptocurrency.screen.detail

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.framgia.domain.entity.MoreCoin
import com.framgia.domain.interactor.GetCoinDetail
import io.reactivex.observers.DisposableObserver
import javax.inject.Inject

class DetailViewModel @Inject constructor(private val getCoinDetail: GetCoinDetail) : ViewModel() {
    var moreCoinDetail = MutableLiveData<MoreCoin>()

    fun getCoiDetaiBySymbol(symbol: String) {
        getCoinDetail.execute(GetCoiDetail(), symbol)
    }

    fun getMoreCoinBySymbol(): MutableLiveData<MoreCoin> {
        return moreCoinDetail
    }

    inner class GetCoiDetail : DisposableObserver<MoreCoin>() {
        override fun onComplete() {
            println("GET MORECOIN")
        }

        override fun onNext(t: MoreCoin) {
            moreCoinDetail.value = t
        }

        override fun onError(e: Throwable) {
            Log.d("ERROR NE: ", e.message)
        }

    }
}