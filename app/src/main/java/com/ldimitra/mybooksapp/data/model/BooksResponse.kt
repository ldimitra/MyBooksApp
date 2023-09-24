package com.ldimitra.mybooksapp.data.model

import com.google.gson.annotations.SerializedName

data class BooksResponse(
    @SerializedName("count") val count: Int?,
    @SerializedName("next") val next: String?,
    @SerializedName("previous") val previous: String?,
    @SerializedName("results") val bookDetails: List<BookDetailsResponse>?
)
