package kg.asylbekov.dagger4.di

import android.content.Context
import dagger.Module
import dagger.Provides
import kg.asylbekov.dagger4.presentation.MainViewModelFactory
import kg.asylbekov.domain.use_cases.GetDataUseCase

@Module
class AppModule(val context: Context) {

    @Provides
    fun provideContext(): Context {
        return context
    }

    @Provides
    fun provideMainVMFactory(dataUseCase: GetDataUseCase): MainViewModelFactory{
        return MainViewModelFactory(dataUseCase)
    }
}