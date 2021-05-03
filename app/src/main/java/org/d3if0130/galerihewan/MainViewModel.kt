package org.d3if0130.galerihewan

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.d3if0130.galerihewan.network.HewanApi

class MainViewModel: ViewModel() {
    private val data = MutableLiveData<List<Hewan>>()
    init {

        retrieveData()
    }
    private fun retrieveData() {
        viewModelScope.launch {
            try {
                data.value = HewanApi.service.getHewan()
            } catch (e: Exception) {
                Log.d("MainViewModel", "Failure: ${e.message}")
            }
        }
    }

    // Data ini akan kita ambil dari server di langkah selanjutnya
    fun getData(): LiveData<List<Hewan>> = data
}