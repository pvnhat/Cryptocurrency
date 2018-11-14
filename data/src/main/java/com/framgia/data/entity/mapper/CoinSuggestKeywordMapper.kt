package com.framgia.data.entity.mapper

import com.framgia.data.entity.model.CoinSuggestKeywordData
import com.framgia.domain.entity.CoinSuggestKeyword
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CoinSuggestKeywordMapper @Inject constructor() {

    fun transform(coinSuggestKeywordData: CoinSuggestKeywordData?): CoinSuggestKeyword? { //co the tra ve null
        if (coinSuggestKeywordData == null) {
            return null
        }
        return CoinSuggestKeyword(coinSuggestKeywordData.symbol)
    }

    fun transform(coinSuggestKeyword: CoinSuggestKeyword?): CoinSuggestKeywordData? { //co the tra ve null
        if (coinSuggestKeyword == null) {
            return null
        }
        return CoinSuggestKeywordData(null, coinSuggestKeyword.symbol)
    }

    fun transformListToKeyword(listCoinSuggestData: List<CoinSuggestKeywordData>?): List<CoinSuggestKeyword>? { //co the tra ve null
        if (listCoinSuggestData == null) {
            return null
        }
        val listCoinSuggest = ArrayList<CoinSuggestKeyword>()
        for (coinSuggestData in listCoinSuggestData) {
            val coinSuggest: CoinSuggestKeyword? = this.transform(coinSuggestData)
            coinSuggest?.let { listCoinSuggest.add(it) }
        }
        return listCoinSuggest
    }

    fun transformListToKeywordData(listCoinSuggest: List<CoinSuggestKeyword?>?): List<CoinSuggestKeywordData>? { //co the tra ve null
        if (listCoinSuggest == null) {
            return null
        }
        val listCoinSuggestData = ArrayList<CoinSuggestKeywordData>()
        for (coinSuggest in listCoinSuggest) {
            val coinSuggestData: CoinSuggestKeywordData? = this.transform(coinSuggest)
            coinSuggestData?.let { listCoinSuggestData.add(coinSuggestData) }
        }
        return listCoinSuggestData
    }
}
