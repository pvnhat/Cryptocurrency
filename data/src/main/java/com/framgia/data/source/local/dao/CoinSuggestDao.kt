package com.framgia.data.source.local.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.framgia.data.entity.model.CoinSuggestKeywordData
import io.reactivex.Flowable
@Dao
interface CoinSuggestDao {
    @Query("SELECT * FROM CoinSuggestKeywordData WHERE symbol LIKE '%' || :symbol || '%'")
    fun getKeywordBySymbol(symbol: String): Flowable<List<CoinSuggestKeywordData>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveCoinKeyword(keywordDataList: List<CoinSuggestKeywordData>)
}
