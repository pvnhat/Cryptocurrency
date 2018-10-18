package com.framgia.domain.repository

import com.framgia.domain.entity.MoreCoin
import com.framgia.domain.entity.MoreCoinDetail
import io.reactivex.Observable

interface ICoinRepository {
//  fun getActiveCoin(startNum: Int): Observable<MoreCoin<CoinDetailResult>>
//

    fun getLastestList(startNum: Int): Observable<MoreCoinDetail>
    //
//  fun getInfoCoin(coinId: Int): Observable<MoreCoin<CoinDetailResult>>
//
    fun getCoinDetail(symbol: String): Observable<MoreCoin>
}
