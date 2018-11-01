package com.framgia.domain.repository

import com.framgia.domain.entity.MoreCoin
import com.framgia.domain.entity.MoreCoinDetail
import com.framgia.domain.entity.MoreCoinInfo
import io.reactivex.Observable

interface ICoinRepository {
//  fun getActiveCoin(startNum: Int): Observable<MoreCoin<CoinDetailResult>>
//

    fun getLastestList(startNum: Int): Observable<MoreCoinDetail>

    fun getInfoCoin(symbol: String): Observable<MoreCoinInfo>

    fun getCoinDetail(symbol: String): Observable<MoreCoin>
}
