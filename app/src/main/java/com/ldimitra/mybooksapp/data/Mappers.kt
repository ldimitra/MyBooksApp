package com.ldimitra.mybooksapp.data

import com.ldimitra.mybooksapp.data.model.AuthorResponse
import com.ldimitra.mybooksapp.data.model.BookDetailsResponse
import com.ldimitra.mybooksapp.data.model.BooksResponse
import com.ldimitra.mybooksapp.data.model.FormatResponse
import com.ldimitra.mybooksapp.domain.model.Author
import com.ldimitra.mybooksapp.domain.model.BookDetails
import com.ldimitra.mybooksapp.domain.model.Books
import com.ldimitra.mybooksapp.domain.model.Format


fun BooksResponse.mapToDomain(): Books {
    return Books(
        count = this.count ?: 0,
        next = this.next ?: "",
        previous = this.previous ?: "",
        bookDetails = bookDetails?.map { it.mapToDomain() } ?: emptyList()
    )
}

fun BookDetailsResponse.mapToDomain(): BookDetails {
    return BookDetails(
        id = this.id ?: 0,
        downloadCount = this.downloadCount ?: 0,
        title = this.title ?: "",
        authors = this.authors?.map { it.mapToDomain() } ?: emptyList(),
        formats = this.formats?.mapToDomain() ?: Format("")
    )
}

fun AuthorResponse.mapToDomain() = Author(
    birthYear = this.birthYear ?: 0,
    deathYear = this.deathYear ?: 0,
    name = this.name ?: ""
)

fun FormatResponse.mapToDomain() = Format(image = this.image ?: "")
