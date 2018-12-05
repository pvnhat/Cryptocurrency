package com.framgia.data.source.local

import com.framgia.data.entity.model.CoinSuggestKeywordData
import com.framgia.data.source.CoinDataSource
import com.framgia.data.source.local.dao.CoinSuggestDao
import io.reactivex.Flowable
import javax.inject.Inject

class CoinLocalDataSource @Inject constructor(val dao: CoinSuggestDao) : CoinDataSource.LocalSource {
    override fun saveSymbolToDB(symbolList: List<CoinSuggestKeywordData>) {
        dao.saveCoinKeyword(symbolList)
    }

    override fun getSuggesFromDB(symbol: String): Flowable<List<CoinSuggestKeywordData>> {
        return dao.getKeywordBySymbol(symbol)
    }

}
