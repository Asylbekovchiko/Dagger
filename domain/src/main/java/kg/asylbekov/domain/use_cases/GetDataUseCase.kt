package kg.asylbekov.domain.use_cases

import kg.asylbekov.domain.models.CoinResponse
import kg.asylbekov.domain.repository.DataRepository
import retrofit2.Response

class GetDataUseCase(val repository: DataRepository) {

    suspend fun getData(): Response<CoinResponse> {
        return repository.getData()
    }
}