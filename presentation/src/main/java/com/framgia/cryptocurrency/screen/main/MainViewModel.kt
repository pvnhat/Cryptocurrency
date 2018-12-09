package com.framgia.cryptocurrency.screen.main

import android.annotation.SuppressLint
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.framgia.domain.entity.CoinSuggestKeyword
import com.framgia.domain.entity.MoreCoinDetail
import com.framgia.domain.interactor.GetLastestList
import com.framgia.domain.interactor.GetSuggestKeyword
import com.framgia.domain.interactor.SaveSuggestKeyword
import io.reactivex.observers.DisposableObserver
import javax.inject.Inject

class MainViewModel @Inject constructor(private val getLatestList: GetLastestList,
    private val saveSuggestKeyword: SaveSuggestKeyword,
    private val getSuggestKeyword: GetSuggestKeyword)
  : ViewModel() {

  var moreCoinDetail = MutableLiveData<MoreCoinDetail>()
  var suggestKeywordList = MutableLiveData<List<CoinSuggestKeyword>>()
  var errorLive = MutableLiveData<String>()
  var isConnectable = MutableLiveData<Boolean>()

  fun saveSuggestKeyword(symbolList: List<CoinSuggestKeyword>) {
    saveSuggestKeyword.buildUseCaseObservable(symbolList)
  }

  @SuppressLint("CheckResult")
  fun getSuggestKeyword(symbol: String) {
    getSuggestKeyword.execute(symbol).subscribe({ t -> suggestKeywordList.value = t },
        { t -> errorLive.value = t?.message })
  }

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
      isConnectable.value = true
    }

    override fun onError(e: Throwable) {
      Log.d("hehe2: ", e.message.toString())
      isConnectable.value = false
    }

  }
}
