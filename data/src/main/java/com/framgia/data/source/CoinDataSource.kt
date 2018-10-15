package com.framgia.data.source

import com.framgia.data.entity.model.MoreCoinData
import io.reactivex.Observable

interface CoinDataSource {
  interface RemoteSource {
    fun getActiveCoin(startNum: Int) : Observable<MoreCoinData<Any>>

    fun getLastestList(startNum: Int): Observable<MoreCoinData<Any>>

    fun getInfoCoin(coinId: Int): Observable<MoreCoinData<Any>>

    fun getCoinDetail(coinId: Int): Observable<MoreCoinData<Any>>
  }

  interface LocalSource {
  }
}
