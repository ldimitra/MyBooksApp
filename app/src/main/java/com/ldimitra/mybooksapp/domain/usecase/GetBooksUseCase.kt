package com.ldimitra.mybooksapp.domain.usecase

import com.ldimitra.mybooksapp.domain.BooksRepository
import com.ldimitra.mybooksapp.domain.DomainResult
import com.ldimitra.mybooksapp.domain.model.Books
import javax.inject.Inject

class GetBooksUseCase @Inject constructor(private val booksRepository: BooksRepository) {

    suspend operator fun invoke(): DomainResult<Books> {
        return booksRepository.getBooks()
    }
}