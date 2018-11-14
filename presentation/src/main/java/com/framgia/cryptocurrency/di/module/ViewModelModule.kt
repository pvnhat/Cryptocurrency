package com.framgia.cryptocurrency.di.module

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.framgia.cryptocurrency.di.ViewModelFactory
import com.framgia.cryptocurrency.di.ViewModelKey
import com.framgia.cryptocurrency.screen.detail.InfoViewModel
import com.framgia.cryptocurrency.screen.main.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

// co view model nao moi them provide vao day
@Module
internal abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    internal abstract fun bindMainViewModel(viewModel: MainViewModel): ViewModel

    /*@Binds
    @IntoMap
    @ViewModelKey(DetailViewModel::class)
    internal abstract fun bindDetailViewModel(viewModel: DetailViewModel): ViewModel*/

    @Binds
    @IntoMap
    @ViewModelKey(InfoViewModel::class)
    internal abstract fun bindInFoViewModel(viewModel: InfoViewModel): ViewModel

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}
