package com.ldimitra.mybooksapp.domain

import com.ldimitra.mybooksapp.domain.model.BookDetails
import com.ldimitra.mybooksapp.domain.model.Books


interface BooksRepository {
    suspend fun getBooks(): DomainResult<Books>
    suspend fun getBookById(bookId: Int): DomainResult<BookDetails>
}
