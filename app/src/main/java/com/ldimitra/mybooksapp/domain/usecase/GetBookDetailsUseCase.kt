package com.ldimitra.mybooksapp.domain.usecase

import com.ldimitra.mybooksapp.domain.BooksRepository
import com.ldimitra.mybooksapp.domain.DomainResult
import com.ldimitra.mybooksapp.domain.model.BookDetails
import javax.inject.Inject

class GetBookDetailsUseCase @Inject constructor(private val booksRepository: BooksRepository) {

    suspend operator fun invoke(bookId: Int): DomainResult<BookDetails> {
        return booksRepository.getBookById(bookId)
    }
}