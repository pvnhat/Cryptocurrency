package com.framgia.cryptocurrency.di.module

import android.arch.lifecycle.ViewModel
import com.framgia.cryptocurrency.di.ViewModelKey
import com.framgia.cryptocurrency.screen.detail.DetailViewModel
import com.framgia.domain.interactor.GetCoinDetail
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

/**
 * Created by GianhTran on 08/11/2018.
 * tran.nguyen.song.gianh@framgia.com
 */

@Module
class AnyModule {
    @Provides
    @IntoMap
    @ViewModelKey(DetailViewModel::class)
    fun bindDetailViewModel(getCoinDetail: GetCoinDetail): ViewModel { // co the truyen getCoinDetail o day vi da duoc inject
        return DetailViewModel(getCoinDetail)
    }
}