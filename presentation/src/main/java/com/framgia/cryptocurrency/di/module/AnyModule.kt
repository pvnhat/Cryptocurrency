package com.framgia.cryptocurrency.di.module

import android.arch.lifecycle.ViewModel
import com.framgia.cryptocurrency.di.ViewModelKey
import com.framgia.cryptocurrency.screen.detail.coin.DetailViewModel
import com.framgia.data.TestViewModel
import com.framgia.domain.interactor.GetCoinDetail
import com.framgia.domain.interactor.TestScope
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap



@Module
class AnyModule {
    @Provides
    @IntoMap
    @ViewModelKey(DetailViewModel::class)
    fun bindDetailViewModel(getCoinDetail: GetCoinDetail): ViewModel { // co the truyen getCoinDetail o day vi da duoc inject
        return DetailViewModel(getCoinDetail)
    }

    @Provides
    @IntoMap
    @ViewModelKey(TestViewModel::class)
    fun bindTestViewModel(): ViewModel { // co the truyen getCoinDetail o day vi da duoc inject
        return TestViewModel()
    }

    @Provides
    fun provideTestScope(testScope: TestScope): String {
        return testScope.toString()
    }

}