package kg.asylbekov.domain.repository

import kg.asylbekov.domain.models.CoinResponse
import retrofit2.Response

interface DataRepository {
    suspend fun getData(): Response<CoinResponse>
}