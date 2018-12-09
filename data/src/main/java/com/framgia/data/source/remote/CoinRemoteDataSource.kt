package com.framgia.data.source.remote

import com.framgia.data.entity.model.CoinDetailResultData
import com.framgia.data.entity.model.MoreCoinData
import com.framgia.data.entity.model.MoreCoinDetailData
import com.framgia.data.entity.model.MoreCoinInfoData
import com.framgia.data.source.CoinDataSource
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Named

class CoinRemoteDataSource @Inject constructor(
    @Named("provideApi1") private val mApi: Api, @Named("provideApi2") private val mApi2: Api) : CoinDataSource.RemoteSource {

  override fun getActiveCoin(startNum: Int): Observable<MoreCoinData> {
    return mApi.getActiveCoin(startNum)
  }

  override fun getLastestList(startNum: Int): Observable<MoreCoinDetailData> {
    return mApi.getLastestList(startNum)
  }

  override fun getInfoCoin(symbol: String): Observable<MoreCoinInfoData> {
    return mApi2.getInfoCoin(symbol)
  }

  override fun getCoinDetail(symbol: String): Observable<MoreCoinData> {
    return mApi.getCoinDetail(symbol)
  }

}
