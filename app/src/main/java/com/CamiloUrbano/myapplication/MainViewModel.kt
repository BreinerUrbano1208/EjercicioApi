package com.CamiloUrbano.myapplication
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.CamiloUrbano.myapplication.network.RetrofitClient
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    // LiveData privado para guardar la URL y público para observarla desde la Activity
    private val _dogImageUrl = MutableLiveData<String?>()
    val dogImageUrl: LiveData<String?> get() = _dogImageUrl

    fun getRandomDogImage() {
        viewModelScope.launch {
            try {
                val response = RetrofitClient.apiService.getRandomDog()
                if (response.isSuccessful && response.body() != null) {
                    // Extraemos la URL del JSON que nos manda la API
                    _dogImageUrl.value = response.body()?.message
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}