package com.example.flickrgallery.di.core

import com.example.flickrgallery.api.FlickrApi
import com.example.flickrgallery.di.AppScope
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class ApiModule {

    @AppScope
    @Provides
    internal fun provideApiService(client: OkHttpClient, gson: GsonConverterFactory, rxAdapter: RxJava2CallAdapterFactory): FlickrApi {
        val retrofit = Retrofit.Builder()
            .client(client)
            .addConverterFactory(gson)
            .addCallAdapterFactory(rxAdapter)
            .build()

        return retrofit.create(FlickrApi::class.java)
    }

    @AppScope
    @Provides
    internal fun provideHttpClient(logger: HttpLoggingInterceptor): OkHttpClient {
        val builder = OkHttpClient()
            .newBuilder()
            .addInterceptor(logger)
        return builder.build()
    }

    @AppScope
    @Provides
    internal fun provideInterceptor(): HttpLoggingInterceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return httpLoggingInterceptor
    }

    @AppScope
    @Provides
    internal fun provideRxAdapter(): RxJava2CallAdapterFactory {
        return RxJava2CallAdapterFactory.create()
    }

    @AppScope
    @Provides
    internal fun provideGsonClient(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }
}