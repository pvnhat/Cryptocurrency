package com.framgia.data.source.remote

import android.app.Application
import com.framgia.cryptocurrency.di.scope.AppScope
import com.framgia.data.BuildConfig
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.internal.DoubleCheck.lazy
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
class NetworkModule(application: Application) {

  companion object {
    private val REQUEST_TIMEOUT: Long = 5000
    private val CONNECT_TIMEOUT: Long = 10000
    private val BASE_LINK: String = "https://pro-api.coinmarketcap.com/v1/"
    private val API_KEY: String =  "X-CMC_PRO_API_KEY"
    private val API_VALUE: String =  BuildConfig.COINMARKETCAP_API_KEY
    private lateinit var sRetrofit: Retrofit
  }

  var mApplication: Application

  init {
    mApplication = application
  }

  @AppScope
  @Provides
  fun provideApplication(): Application {
    return mApplication
  }

  @AppScope
  @Provides
  fun provideOkHttpCache(application: Application): Cache {
    return Cache(application.cacheDir, 10 * 10 * 1024)
  }

  @AppScope
  @Provides
  fun provideOkHttpClient(cache: Cache): OkHttpClient {
    return OkHttpClient.Builder().cache(cache)
        .readTimeout(REQUEST_TIMEOUT, TimeUnit.MILLISECONDS)
        .writeTimeout(REQUEST_TIMEOUT, TimeUnit.MILLISECONDS)
        .connectTimeout(CONNECT_TIMEOUT, TimeUnit.MILLISECONDS)
        .retryOnConnectionFailure(true)
        .addInterceptor(Interceptor { chain ->
          chain.proceed(chain.request().newBuilder().addHeader(API_KEY,
              API_VALUE).build())
        })
        .build()
  }

  @AppScope
  @Provides
  fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    if (true) {
      var gson: Gson = GsonBuilder().setLenient().create()
      sRetrofit = Retrofit.Builder().baseUrl(BASE_LINK)
          .client(okHttpClient)
          .addConverterFactory(GsonConverterFactory.create(gson))
          .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
          .build()
    }
    return sRetrofit
  }

  @AppScope
  @Provides
  fun provideApi(retrofit: Retrofit): Api {
    return retrofit.create(Api::class.java)
  }

}