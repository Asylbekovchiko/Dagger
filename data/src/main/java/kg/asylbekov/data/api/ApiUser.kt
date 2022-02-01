package kg.asylbekov.data.api

import kg.asylbekov.domain.models.CoinResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiUser {

    @GET("currentprice.json")
    suspend fun getData(): Response<CoinResponse>

}