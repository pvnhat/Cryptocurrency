package com.framgia.cryptocurrency.di.module

import com.framgia.cryptocurrency.screen.active.ActiveCoinActivity
import com.framgia.cryptocurrency.screen.detail.DetailActivity
import com.framgia.cryptocurrency.screen.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {
  @ContributesAndroidInjector // voi moi Activity duoc tao ra thi them dong nay
  abstract fun provideMainActivity(): MainActivity

  @ContributesAndroidInjector(
      modules = [FragmentModule::class]) // voi moi Activity duoc tao ra thi them dong nay
  abstract fun provideDetailActivity(): DetailActivity

  @ContributesAndroidInjector // voi moi Activity duoc tao ra thi them dong nay
  abstract fun provideActiveCoinActivity(): ActiveCoinActivity
}
