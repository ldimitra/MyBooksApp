package com.ldimitra.mybooksapp.data.model

import com.google.gson.annotations.SerializedName

data class AuthorResponse(
    @SerializedName("birth_year")
    val birthYear: Int?,
    @SerializedName("death_year")
    val deathYear: Int?,
    @SerializedName("name")
    val name: String?
)
