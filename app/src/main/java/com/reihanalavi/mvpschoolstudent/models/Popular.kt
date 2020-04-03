package com.reihanalavi.mvpschoolstudent.models

import com.google.gson.annotations.SerializedName

data class Popular (
    @SerializedName("original_language") val id: String,
    @SerializedName("title") val title: String,
    @SerializedName("release_date") val release: String
)