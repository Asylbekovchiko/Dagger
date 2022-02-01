package kg.asylbekov.domain.models


import com.google.gson.annotations.SerializedName

data class Bpi(
    @SerializedName("EUR")
    val eUR: EUR,
    @SerializedName("GBP")
    val gBP: GBP,
    @SerializedName("USD")
    val uSD: USD
)