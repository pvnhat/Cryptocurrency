package com.framgia.data.entity.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by GianhTran on 14/11/2018.
 * tran.nguyen.song.gianh@framgia.com
 */
@Entity(tableName = "CoinSuggestKeywordData")
data class CoinSuggestKeywordData(
        @ColumnInfo(name = "id")
        val id: Int?,
        @PrimaryKey
        @ColumnInfo(name = "symbol")
        val symbol: String
)
