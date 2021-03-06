package com.framgia.data.source.remote

import com.framgia.data.BuildConfig
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetworkModule {

    companion object {
        private val REQUEST_TIMEOUT: Long = 5000
        private val CONNECT_TIMEOUT: Long = 10000
        private val BASE_LINK: String = "https://pro-api.coinmarketcap.com/v1/"
        private val API_KEY: String = "X-CMC_PRO_API_KEY"
        private val API_VALUE: String = BuildConfig.COINMARKETCAP_API_KEY
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        return OkHttpClient.Builder()
                .readTimeout(REQUEST_TIMEOUT, TimeUnit.MILLISECONDS)
                .writeTimeout(REQUEST_TIMEOUT, TimeUnit.MILLISECONDS)
                .connectTimeout(CONNECT_TIMEOUT, TimeUnit.MILLISECONDS)
                .retryOnConnectionFailure(true)
                .addInterceptor(httpLoggingInterceptor)
                .addInterceptor { chain ->
                    chain.proceed(chain.request().newBuilder().addHeader(API_KEY,
                            API_VALUE).build())
                }
                .build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        val gson: Gson = GsonBuilder().setLenient().create()
        return Retrofit.Builder().baseUrl(BASE_LINK)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }

    @Singleton
    @Provides
    internal fun provideApi(retrofit: Retrofit): Api {
        return retrofit.create(Api::class.java)
    }

}
