package com.framgia.cryptocurrency

import android.annotation.SuppressLint
import com.framgia.cryptocurrency.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

@SuppressLint("Registered")
class App : DaggerApplication() {
    override fun onCreate() {
        super.onCreate()
    }
    override fun applicationInjector(): AndroidInjector<out App> {
        return DaggerAppComponent.builder().create(this) // Dagger...nt duoc lay tu AppComponent
    }
}
