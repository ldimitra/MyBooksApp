package com.ldimitra.mybooksapp.data

import com.ldimitra.mybooksapp.data.model.BookDetailsResponse
import com.ldimitra.mybooksapp.data.model.BooksResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface BooksApi {
    @GET("/books")
    suspend fun getBooks(): Response<BooksResponse>

    @GET("/books/{id}")
    suspend fun getBookById(@Path("id") bookId: Int): Response<BookDetailsResponse>
}