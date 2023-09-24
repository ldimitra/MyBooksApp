package com.ldimitra.mybooksapp.domain.model

data class BookDetails(
    val id: Int,
    val title: String,
    val authors: List<Author>,
    val formats: Format,
    val downloadCount: Int
)
