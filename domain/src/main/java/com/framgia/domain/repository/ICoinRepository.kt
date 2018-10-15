package com.framgia.domain.repository

import io.reactivex.Observable

interface ICoinRepository {
  fun getActiveCoin(startNum: Int): Observable<Coin<Any>>
}