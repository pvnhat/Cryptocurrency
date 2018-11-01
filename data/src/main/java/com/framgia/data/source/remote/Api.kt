package com.framgia.data.source.remote

import com.framgia.data.entity.model.MoreCoinData
import com.framgia.data.entity.model.MoreCoinDetailData
import com.framgia.data.entity.model.MoreCoinInfoData
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET("cryptocurrency/map?listing_status=active&limit=20")
    fun getActiveCoin(@Query("start") startNum: Int): Observable<MoreCoinData>

    @GET("cryptocurrency/listings/latest?limit=20")
    fun getLastestList(@Query(
            "start") startNum: Int): Observable<MoreCoinDetailData>

    @GET("cryptocurrency/info")
    fun getInfoCoin(@Query("symbol") symbol: String): Observable<MoreCoinInfoData>

    @GET("cryptocurrency/quotes/latest")
    fun getCoinDetail(@Query("symbol") coinId: String): Observable<MoreCoinData>

}