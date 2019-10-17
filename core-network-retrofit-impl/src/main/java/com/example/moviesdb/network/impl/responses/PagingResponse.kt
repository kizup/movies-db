package com.example.moviesdb.network.impl.responses

import com.google.gson.annotations.SerializedName

data class PagingResponse<Result>(
    @SerializedName("page") val page: Int?,
    @SerializedName("total_results") val totalResults: Int?,
    @SerializedName("total_pages") val totalPages: Int?,
    @SerializedName("results") val results: List<Result>?
)