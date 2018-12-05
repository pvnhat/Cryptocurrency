package com.framgia.cryptocurrency.di

import com.framgia.cryptocurrency.App
import com.framgia.cryptocurrency.di.module.*
import com.framgia.data.source.remote.NetworkModule
import com.framgia.domain.scope.CustomScope
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


@CustomScope
@Singleton // cac module dung scope nao thi phải add hết scopce : lỗi difference scope
@Component(modules = [AndroidSupportInjectionModule::class,
    (ActivityModule::class),
    (ViewModelModule::class),
    (NetworkModule::class),
    (ApplicationModule::class),
    (AnyModule::class),
    (DatabaseModule::class)])

interface AppComponent : AndroidInjector<App> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<App>()

    /*@Component.Builder
    interface Builder {
        @BindsInstance

        fun application(application: Application): Builder

        fun build(): AppComponent
    }*/
}
