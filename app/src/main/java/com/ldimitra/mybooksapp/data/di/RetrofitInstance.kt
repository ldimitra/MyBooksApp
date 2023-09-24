package com.ldimitra.mybooksapp.data.di


import com.ldimitra.mybooksapp.data.BooksApi
import com.ldimitra.mybooksapp.domain.BooksRepository
import com.ldimitra.mybooksapp.data.BooksRepositoryImpl
import com.ldimitra.mybooksapp.data.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitInstance {

    @Singleton
    @Provides
    fun provideBaseUrl(): String {
        return BASE_URL
    }

    @Singleton
    @Provides
    fun providesHttpLoggingInterceptor() = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    @Singleton
    @Provides
    fun providesOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient =
        OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build()

    @Singleton
    @Provides
    fun provideRetrofit(baseUrl: String, okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .client(okHttpClient).build()

    @Singleton
    @Provides
    fun provideBooksApi(retrofit: Retrofit): BooksApi {
        return retrofit.create(BooksApi::class.java)
    }

    @Singleton
    @Provides
    fun providesRepository(booksRepository: BooksRepositoryImpl): BooksRepository = booksRepository


}