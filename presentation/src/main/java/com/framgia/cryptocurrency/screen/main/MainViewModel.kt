package com.framgia.cryptocurrency.screen.main

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.framgia.domain.entity.MoreCoinDetail
import com.framgia.domain.interactor.GetLastestList
import io.reactivex.observers.DisposableObserver
import javax.inject.Inject

class MainViewModel @Inject constructor(private val getLatestList: GetLastestList) : ViewModel() {

    var moreCoinDetail = MutableLiveData<MoreCoinDetail>()

    fun getLatestCoin(startNum: Int) {
        getLatestList.execute(LatestListObserver(), startNum)
    }

    fun getMoreCoiDetail(): MutableLiveData<MoreCoinDetail> {
        return moreCoinDetail
    }

    inner class LatestListObserver : DisposableObserver<MoreCoinDetail>() {
        override fun onComplete() {
        }

        override fun onNext(t: MoreCoinDetail) {
            moreCoinDetail.value = t
        }

        override fun onError(e: Throwable) {
        }

    }
}
