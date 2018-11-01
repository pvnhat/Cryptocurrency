package com.framgia.cryptocurrency.screen.main

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.framgia.domain.entity.MoreCoinDetail
import com.framgia.domain.interactor.GetLastestList
import io.reactivex.observers.DisposableObserver
import javax.inject.Inject

class MainViewModel @Inject constructor(private val getLatestList: GetLastestList) : ViewModel() {

    var moreCoinDetail = MutableLiveData<MoreCoinDetail>()

    fun getLatestCoin() {
        getLatestList.execute(LatestListObserver(), 20)
    }

    fun getMoreCoiDetail(): MutableLiveData<MoreCoinDetail> {
        return moreCoinDetail
    }

    inner class LatestListObserver : DisposableObserver<MoreCoinDetail>() {
        override fun onComplete() {
            Log.d("COMPLETE: ", "FETCHED DATA SUCCESS !")
        }

        override fun onNext(t: MoreCoinDetail) {
            Log.d("YES : ", t.listCoin!!.size.toString())
            moreCoinDetail!!.value = t
        }

        override fun onError(e: Throwable) {
            Log.d("ERROR: ", e.message)
        }

    }
}
