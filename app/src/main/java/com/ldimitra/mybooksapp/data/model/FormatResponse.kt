package com.ldimitra.mybooksapp.data.model

import com.google.gson.annotations.SerializedName

data class FormatResponse(
    @SerializedName("image/jpeg") val image: String?
)
