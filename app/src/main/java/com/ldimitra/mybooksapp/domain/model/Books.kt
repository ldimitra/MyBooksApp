package com.ldimitra.mybooksapp.domain.model

data class Books(
    val count: Int,
    val next: String,
    val previous: String,
    val bookDetails: List<BookDetails>
)

