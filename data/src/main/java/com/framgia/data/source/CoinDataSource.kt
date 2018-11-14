package com.framgia.data.source

import com.framgia.data.entity.model.CoinSuggestKeywordData
import com.framgia.data.entity.model.MoreCoinData
import com.framgia.data.entity.model.MoreCoinDetailData
import com.framgia.data.entity.model.MoreCoinInfoData
import io.reactivex.Flowable
import io.reactivex.Observable

interface CoinDataSource {
    interface RemoteSource {
        fun getActiveCoin(startNum: Int): Observable<MoreCoinData>

        fun getLastestList(startNum: Int): Observable<MoreCoinDetailData>

        fun getInfoCoin(symbol: String): Observable<MoreCoinInfoData>

        fun getCoinDetail(symbol: String): Observable<MoreCoinData>
    }

    interface LocalSource {
        fun saveSymbolToDB(symbolList: List<CoinSuggestKeywordData>)

        fun getSuggesFromDB(symbol: String): Flowable<List<CoinSuggestKeywordData>>
    }
}
