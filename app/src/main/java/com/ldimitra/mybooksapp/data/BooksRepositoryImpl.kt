package com.ldimitra.mybooksapp.data

import com.ldimitra.mybooksapp.domain.DomainResult
import com.ldimitra.mybooksapp.domain.BooksRepository
import com.ldimitra.mybooksapp.domain.model.BookDetails
import com.ldimitra.mybooksapp.domain.model.Books
import retrofit2.HttpException
import javax.inject.Inject


class BooksRepositoryImpl @Inject constructor(private val booksApi: BooksApi) : BooksRepository {
    override suspend fun getBooks(): DomainResult<Books> {
        return try {
            val response = booksApi.getBooks()
            val body = response.body()
            if (response.isSuccessful && body != null) {
                DomainResult.Success(body.mapToDomain())
            } else {
                DomainResult.Error(code = response.code(), message = response.message())
            }
        } catch (e: HttpException) {
            DomainResult.Error(code = e.code(), message = e.message())
        } catch (e: Throwable) {
            DomainResult.Exception(e)
        }
    }


    override suspend fun getBookById(bookId: Int): DomainResult<BookDetails> {
        return try {
            val response = booksApi.getBookById(bookId)
            val body = response.body()
            if (response.isSuccessful && body != null) {
                DomainResult.Success(body.mapToDomain())
            } else {
                DomainResult.Error(code = response.code(), message = response.message())
            }
        } catch (e: HttpException) {
            DomainResult.Error(code = e.code(), message = e.message())
        } catch (e: Throwable) {
            DomainResult.Exception(e)
        }
    }

}