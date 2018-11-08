package com.framgia.cryptocurrency.di

import com.framgia.cryptocurrency.App
import com.framgia.cryptocurrency.di.module.ActivityModule
import com.framgia.cryptocurrency.di.module.AnyModule
import com.framgia.cryptocurrency.di.module.ApplicationModule
import com.framgia.cryptocurrency.di.module.ViewModelModule
import com.framgia.data.di.scope.AppScope
import com.framgia.data.source.remote.NetworkModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@AppScope
@Singleton // cac module dung scope nao thi phải add hết scopce : lỗi difference scope
@Component(modules = [(AndroidSupportInjectionModule::class),
    (ActivityModule::class),
    (ViewModelModule::class),
    (NetworkModule::class),
    (ApplicationModule::class),
    (AnyModule::class)])

interface AppComponent : AndroidInjector<App> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<App>()
}
