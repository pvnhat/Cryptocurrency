package com.framgia.data.source.remote

import com.framgia.data.entity.model.MoreCoinData
import com.framgia.data.source.CoinDataSource
import io.reactivex.Observable

class CoinRemoteDataSource(api: Api) : CoinDataSource.RemoteSource {

  private var mApi: Api

  init {
    mApi = api
  }

  override fun getActiveCoin(startNum: Int): Observable<MoreCoinData<Any>> {
    return mApi.getActiveCoin(startNum)
  }

  override fun getLastestList(startNum: Int): Observable<MoreCoinData<Any>> {
    return mApi.getLastestList(startNum)
  }

  override fun getInfoCoin(coinId: Int): Observable<MoreCoinData<Any>> {
    return mApi.getInfoCoin(coinId)
  }

  override fun getCoinDetail(coinId: Int): Observable<MoreCoinData<Any>> {
    return mApi.getCoinDetail(coinId)
  }

}
