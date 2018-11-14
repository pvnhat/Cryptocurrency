package com.framgia.cryptocurrency.di.module

import android.app.Application
import com.framgia.cryptocurrency.UIThread
import com.framgia.data.executor.JobExecutor
import com.framgia.data.repository.CoinRepository
import com.framgia.domain.executor.PostExecutorThread
import com.framgia.domain.executor.ThreadExecutor
import com.framgia.domain.repository.ICoinRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule {

    @Singleton
    @Provides
    internal fun provideThreadExecutor(jobExecutor: JobExecutor): ThreadExecutor {
        return jobExecutor
    }

    @Singleton
    @Provides
    internal fun providePostExecutionThread(uiThread: UIThread): PostExecutorThread {
        return uiThread
    }


    @Singleton
    @Provides
    internal fun provideCoinRepository(coinRepository: CoinRepository): ICoinRepository {
        return coinRepository
    }

    @Singleton
    @Provides
    internal fun provideApplicationContext(application: Application): Application {
        return application
    }
}
