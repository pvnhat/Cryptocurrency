package com.framgia.data.source.remote

import com.framgia.data.entity.model.MoreCoinData
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

  @GET("cryptocurrency/map?listing_status=active&limit=20")
  fun getActiveCoin(@Query("start") startNum: Int): Observable<MoreCoinData<Any>>

  @GET("cryptocurrency/listings/latest?limit=20")
  fun getLastestList(@Query("start") startNum: Int): Observable<MoreCoinData<Any>>

  @GET("cryptocurrency/info")
  fun getInfoCoin(@Query("id") coinId: Int): Observable<MoreCoinData<Any>>

  @GET("cryptocurrency/quotes/latest")
  fun getCoinDetail(@Query("id") coinId: Int): Observable<MoreCoinData<Any>>

}