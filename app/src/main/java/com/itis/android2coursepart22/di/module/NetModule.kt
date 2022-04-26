package com.itis.android2coursepart22.di.module

import com.itis.android2coursepart22.BuildConfig
import com.itis.android2coursepart22.data.api.BrewApi
import com.itis.android2coursepart22.di.qualifier.ApiKeyInterceptor
import com.itis.android2coursepart22.di.qualifier.LoggingInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://api.punkapi.com/v2/"

@Module
class NetModule {

//    @Provides
//    @ApiKeyInterceptor
//    fun apiKeyInterceptor(): Interceptor = Interceptor { chain ->
//        val original = chain.request()
//        val newURL = original.url.newBuilder()
//            .addQueryParameter(QUERY_API_KEY, API_KEY)
//            .build()
//
//        chain.proceed(
//            original.newBuilder()
//                .url(newURL)
//                .build()
//        )
//    }

    @Provides
    @LoggingInterceptor
    fun provideLoggingInterceptor(): Interceptor = HttpLoggingInterceptor()
        .setLevel(HttpLoggingInterceptor.Level.BODY)

    @Provides
    fun provideOkhttp(
        @LoggingInterceptor loggingInterceptor: Interceptor,
    ): OkHttpClient =
        OkHttpClient.Builder()
//            .addInterceptor(apiKeyInterceptor)
            .also {
                if (BuildConfig.DEBUG) {
                    it.addInterceptor(loggingInterceptor)
                }
            }
            .build()

    @Provides
    fun provideGsonConverter(): GsonConverterFactory = GsonConverterFactory.create()

    @Provides
    fun provideApi(
        okHttpClient: OkHttpClient,
        gsonConverter: GsonConverterFactory,
    ): BrewApi = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(gsonConverter)
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .build()
        .create(BrewApi::class.java)
}