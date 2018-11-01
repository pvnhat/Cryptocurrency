package com.framgia.data.source

import com.framgia.data.entity.model.CoinDetailResultData
import com.framgia.data.entity.model.MoreCoinData
import com.framgia.data.entity.model.MoreCoinDetailData
import io.reactivex.Observable

interface CoinDataSource {
    interface RemoteSource {
        fun getActiveCoin(startNum: Int): Observable<MoreCoinData>

        fun getLastestList(startNum: Int): Observable<MoreCoinDetailData>

        fun getInfoCoin(symbol: String): Observable<MoreCoinData>

        fun getCoinDetail(symbol: String): Observable<MoreCoinData>
    }

    interface LocalSource
}
