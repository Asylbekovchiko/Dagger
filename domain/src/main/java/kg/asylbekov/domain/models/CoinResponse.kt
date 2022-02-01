package kg.asylbekov.domain.models


import com.google.gson.annotations.SerializedName

data class CoinResponse(
    @SerializedName("bpi")
    val bpi: Bpi,
    @SerializedName("chartName")
    val chartName: String,
    @SerializedName("disclaimer")
    val disclaimer: String,
    @SerializedName("time")
    val time: Time
)