package com.framgia.cryptocurrency.di.module

import com.framgia.cryptocurrency.screen.detail.chart.ChartFragment
import com.framgia.cryptocurrency.screen.detail.coin.DetailFragment
import com.framgia.cryptocurrency.screen.detail.info.InfoFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {
    @ContributesAndroidInjector
    abstract fun provideDetailFragment(): DetailFragment

    @ContributesAndroidInjector
    abstract fun provideInfoFragment(): InfoFragment

    @ContributesAndroidInjector
    abstract fun provideChartFragment(): ChartFragment
}
