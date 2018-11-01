package com.framgia.data.repository

import com.framgia.data.di.scope.AppScope
import com.framgia.data.entity.mapper.MoreCoinDetailMapper
import com.framgia.data.entity.mapper.MoreCoinInfoMapper
import com.framgia.data.entity.mapper.MoreCoinMapper
import com.framgia.data.source.remote.CoinRemoteDataSource
import com.framgia.domain.entity.MoreCoin
import com.framgia.domain.entity.MoreCoinDetail
import com.framgia.domain.entity.MoreCoinInfo
import com.framgia.domain.repository.ICoinRepository
import io.reactivex.Observable
import javax.inject.Inject

@AppScope
class CoinRepository @Inject constructor(
        private val mCoinRemoteDataSource: CoinRemoteDataSource,
        private val mMoreCoinInfoMapper: MoreCoinInfoMapper,
        private val mMoreCoinMapper: MoreCoinMapper,
        private val mMoreCoinDetailMapper: MoreCoinDetailMapper) : ICoinRepository {

    //  override fun getActiveCoin(startNum: Int): Observable<MoreCoin<Any>> {
//    return mCoinRemoteDataSource.getActiveCoin(startNum).map(mMoreCoinMapper::transform)
//  }
//
    override fun getLastestList(startNum: Int): Observable<MoreCoinDetail> {
        return mCoinRemoteDataSource.getLastestList(startNum).map(mMoreCoinDetailMapper::transform)
    }

    override fun getInfoCoin(symbol: String): Observable<MoreCoinInfo> {
        return mCoinRemoteDataSource.getInfoCoin(symbol).map(mMoreCoinInfoMapper::transform)
    }

    override fun getCoinDetail(system: String): Observable<MoreCoin> {
        return mCoinRemoteDataSource.getCoinDetail(system).map(mMoreCoinMapper::transform)
    }
}
