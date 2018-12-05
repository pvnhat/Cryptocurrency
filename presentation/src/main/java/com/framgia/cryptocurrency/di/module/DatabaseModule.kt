package com.framgia.cryptocurrency.di.module

import android.arch.persistence.room.Room
import com.framgia.cryptocurrency.App
import com.framgia.cryptocurrency.utils.Const
import com.framgia.data.source.local.AppDatabase
import com.framgia.data.source.local.dao.CoinSuggestDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton



@Module
class DatabaseModule {
    @Singleton
    @Provides
    internal fun provideAppDB(app: App): AppDatabase {
        return Room.databaseBuilder(app, AppDatabase::class.java, "database").fallbackToDestructiveMigration().build()
    }

    @Singleton
    @Provides
    internal fun provideCoinSuggestDao(appDatabase: AppDatabase) : CoinSuggestDao {
        return appDatabase.coinSuggestKeywordDao()
    }
}
