package kg.asylbekov.data.repository

import kg.asylbekov.data.api.ApiUser
import kg.asylbekov.domain.models.CoinResponse
import kg.asylbekov.domain.repository.DataRepository
import retrofit2.Response

class DataRepositoryImpl(val apiUser: ApiUser): DataRepository {

    override suspend fun getData(): Response<CoinResponse> {
        return apiUser.getData()
    }

}