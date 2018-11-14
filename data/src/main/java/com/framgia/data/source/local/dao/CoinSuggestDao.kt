package com.framgia.data.source.local.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.framgia.data.entity.model.CoinSuggestKeywordData
import io.reactivex.Flowable

/**
 * Created by GianhTran on 14/11/2018.
 * tran.nguyen.song.gianh@framgia.com
 */
@Dao
interface CoinSuggestDao {
    @Query("SELECT * FROM CoinSuggestKeywordData WHERE symbol LIKE '%' || :symbol || '%'")
    fun getKeywordBySymbol(symbol: String): Flowable<List<CoinSuggestKeywordData>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveCoinKeyword(keywordDataList: List<CoinSuggestKeywordData>)
}
