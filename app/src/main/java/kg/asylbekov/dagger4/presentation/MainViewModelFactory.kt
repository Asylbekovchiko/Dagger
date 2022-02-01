package kg.asylbekov.dagger4.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kg.asylbekov.domain.use_cases.GetDataUseCase

class MainViewModelFactory(val data: GetDataUseCase): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(data) as T

    }
}