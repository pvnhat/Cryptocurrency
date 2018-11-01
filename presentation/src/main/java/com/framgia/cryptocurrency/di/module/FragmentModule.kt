package com.framgia.cryptocurrency.di.module

import com.framgia.cryptocurrency.screen.detail.DetailFragment
import com.framgia.cryptocurrency.screen.detail.InfoFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {
    @ContributesAndroidInjector
    abstract fun provideDetailFragment(): DetailFragment

    @ContributesAndroidInjector
    abstract fun provideInfoFragment(): InfoFragment
}