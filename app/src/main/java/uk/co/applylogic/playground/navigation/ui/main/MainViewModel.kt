package uk.co.applylogic.playground.navigation.ui.main

import android.app.Application
import androidx.lifecycle.*

class MainViewModel(private val app: Application, private val savedStateHandle: SavedStateHandle) :
    AndroidViewModel(app) {

//    lateinit var movieRepository: BlogRepository
//    val allBlog: LiveData<List<Blog>> get() = movieRepository.getMutableLiveData()

    companion object {
        private const val TAG_DATA = "DATA"
    }
    private val _data : MutableLiveData<String> = savedStateHandle.getLiveData(TAG_DATA)
    // Only expose a immutable LiveData
    val data : LiveData<String> = _data

    fun saveData(data: String) {
        savedStateHandle.set(TAG_DATA, data)
    }

    fun getData(): String {
        return savedStateHandle.get(TAG_DATA) ?: ""
    }

    fun onViewCreated() {

    }
}
