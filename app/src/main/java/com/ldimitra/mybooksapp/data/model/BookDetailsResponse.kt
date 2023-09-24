package com.ldimitra.mybooksapp.data.model

import com.google.gson.annotations.SerializedName

data class BookDetailsResponse(
    @SerializedName("id") val id: Int?,
    @SerializedName("title") val title: String?,
    @SerializedName("authors") val authors: List<AuthorResponse>?,
    @SerializedName("formats") val formats: FormatResponse?,
    @SerializedName("download_count") val downloadCount: Int?
)
