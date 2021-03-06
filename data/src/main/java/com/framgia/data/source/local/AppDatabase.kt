package com.framgia.data.source.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import com.framgia.data.entity.model.CoinSuggestKeywordData
import com.framgia.data.source.local.dao.CoinSuggestDao

/**
 * Created by VanNhat on 14/11/2018.
 */
@Database(entities = [CoinSuggestKeywordData::class], version = 1, exportSchema = false)
@TypeConverters(Converter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun coinSuggestKeywordDao(): CoinSuggestDao
}
