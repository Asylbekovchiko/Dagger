package kg.asylbekov.domain.models

import com.google.gson.annotations.SerializedName

data class Currency(
    val code: String,
    val description: String,
    val rate: String,
    val rateFloat: Double,
    val symbol: String
)
