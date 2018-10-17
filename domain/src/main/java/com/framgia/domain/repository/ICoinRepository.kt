package com.framgia.domain.repository

import com.framgia.domain.entity.MoreCoin
import io.reactivex.Observable

interface ICoinRepository {
  fun getActiveCoin(startNum: Int): Observable<MoreCoin<Any>>

  fun getLastestList(startNum: Int): Observable<MoreCoin<Any>>

  fun getInfoCoin(coinId: Int): Observable<MoreCoin<Any>>

  fun getCoinDetail(coinId: Int): Observable<MoreCoin<Any>>
}