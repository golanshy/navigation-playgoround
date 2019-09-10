package uk.co.applylogic.playground.navigation.ui.main

import android.app.Application
import androidx.lifecycle.*
import androidx.work.*
import uk.co.applylogic.playground.navigation.worker.MyWorker

class MainViewModel(val app: Application, private val savedStateHandle: SavedStateHandle) :
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

        // workDataOf (part of KTX) converts a list of pairs to a [Data] object.
        val inputFields = workDataOf("field_id_1" to "12345", "field_id_2" to "7.44", "field_id_3" to 18, "field_id_4" to 7.55F)

        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()

        val workRequest = OneTimeWorkRequestBuilder<MyWorker>()
            .setInputData(inputFields)
            .setConstraints(constraints)
            .build()

        WorkManager.getInstance(app).enqueue(workRequest)
    }
}
