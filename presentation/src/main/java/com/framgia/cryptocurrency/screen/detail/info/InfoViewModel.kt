package com.framgia.cryptocurrency.screen.detail.info

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.framgia.domain.entity.MoreCoinInfo
import com.framgia.domain.interactor.GetCoinInfo
import io.reactivex.observers.DisposableObserver
import javax.inject.Inject


class InfoViewModel @Inject constructor(private val getCoinInfo: GetCoinInfo) : ViewModel() {
    var moreCoinInfo = MutableLiveData<MoreCoinInfo>()

    fun getCoiInfoBySymbol(symbol: String) {
        getCoinInfo.execute(GetCoinInfoObserver(), symbol)
    }

    fun getLiveMoreCoiInfo(): MutableLiveData<MoreCoinInfo> {
        return moreCoinInfo
    }

    inner class GetCoinInfoObserver : DisposableObserver<MoreCoinInfo>() {
        override fun onComplete() {
        }

        override fun onNext(t: MoreCoinInfo) {
            moreCoinInfo.value = t
        }

        override fun onError(e: Throwable) {
        }

    }
}
