package com.framgia.cryptocurrency.di.module

import com.framgia.cryptocurrency.UIThread
import com.framgia.data.di.scope.AppScope
import com.framgia.data.executor.JobExecutor
import com.framgia.data.repository.CoinRepository
import com.framgia.domain.executor.PostExecutorThread
import com.framgia.domain.executor.ThreadExecutor
import com.framgia.domain.repository.ICoinRepository
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule {

  @AppScope
  @Provides
  internal fun provideThreadExecutor(jobExecutor: JobExecutor): ThreadExecutor {
    return jobExecutor
  }

  @AppScope
  @Provides
  internal fun providePostExecutionThread(uiThread: UIThread): PostExecutorThread {
    return uiThread
  }


  @AppScope
  @Provides
  internal fun provideCoinRepository(coinRepository: CoinRepository): ICoinRepository {
    return coinRepository
  }
}
