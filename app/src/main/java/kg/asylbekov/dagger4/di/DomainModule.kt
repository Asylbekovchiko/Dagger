package kg.asylbekov.dagger4.di

import dagger.Module
import dagger.Provides
import kg.asylbekov.domain.repository.DataRepository
import kg.asylbekov.domain.use_cases.GetDataUseCase

@Module
class DomainModule {

    @Provides
    fun provideGetDataUseCase(repo: DataRepository): GetDataUseCase {
        return GetDataUseCase(repo)
    }
}