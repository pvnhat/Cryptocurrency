package com.framgia.data.repository

import com.framgia.cryptocurrency.di.scope.AppScope
import com.framgia.data.entity.mapper.MoreCoinMapper
import com.framgia.data.source.CoinDataSource
import com.framgia.data.source.local.CoinLocalDataSource
import com.framgia.data.source.remote.CoinRemoteDataSource
import com.framgia.domain.entity.MoreCoin
import com.framgia.domain.repository.ICoinRepository
import io.reactivex.Observable
import javax.inject.Inject

@AppScope
class CoinRepository() : ICoinRepository {

  private lateinit var mCoinRemoteDataSource: CoinDataSource.RemoteSource
  private lateinit var mCoinLocalDataSource: CoinDataSource.LocalSource
  private lateinit var mMoreCoinMapper: MoreCoinMapper

  @Inject
  constructor(coinRemoteDataSource: CoinRemoteDataSource,
      coinLocalDataSource: CoinLocalDataSource, moreCoinMapper: MoreCoinMapper) : this() {
    mCoinRemoteDataSource = coinRemoteDataSource
    mCoinLocalDataSource = coinLocalDataSource
    mMoreCoinMapper = moreCoinMapper
  }

  override fun getActiveCoin(startNum: Int): Observable<MoreCoin<Any>> {
    return mCoinRemoteDataSource.getActiveCoin(startNum).map(mMoreCoinMapper::transform)
  }

  override fun getLastestList(startNum: Int): Observable<MoreCoin<Any>> {
    return mCoinRemoteDataSource.getLastestList(startNum).map(mMoreCoinMapper::transform)
  }

  override fun getInfoCoin(coinId: Int): Observable<MoreCoin<Any>> {
    return mCoinRemoteDataSource.getInfoCoin(coinId).map(mMoreCoinMapper::transform)
  }

  override fun getCoinDetail(coinId: Int): Observable<MoreCoin<Any>> {
    return mCoinRemoteDataSource.getCoinDetail(coinId).map(mMoreCoinMapper::transform)
  }
}