package kg.asylbekov.dagger4.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kg.asylbekov.domain.models.CoinResponse
import kg.asylbekov.domain.use_cases.GetDataUseCase
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(
    private val data: GetDataUseCase
) : ViewModel() {

    val _mld = MutableLiveData<CoinResponse>()
    val _ld: LiveData<CoinResponse> = _mld

    suspend fun getData() {

        viewModelScope.launch {
            val response = data.getData()

            if (response!!.isSuccessful) {
                _mld.postValue(response.body())
            } else {
                Log.e("Error", "Error")
            }
        }
    }


}