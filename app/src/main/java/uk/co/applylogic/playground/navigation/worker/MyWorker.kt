package uk.co.applylogic.playground.navigation.worker

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import androidx.work.workDataOf

/**
 * Created by Golan Shay @golanshy on 27 June,2019
 */
class MyWorker(appContext: Context, workerParams: WorkerParameters) : CoroutineWorker(appContext, workerParams) {

    override suspend fun doWork(): Result {

        return try {
            // Do something
            val inputField_1 = inputData.getString("field_id_1")
            val inputField_2 = inputData.getString("field_id_2")
            val inputField_3 = inputData.getInt("field_id_3", 0)
            val inputField_4 = inputData.getFloat("field_id_4", 0F)

            val outputData =
                workDataOf("field_id_1" to 111, "field_id_2" to 222, "field_id_3" to "333", "field_id_4" to "444")

            Result.success(outputData)
        } catch (error: Throwable) {
            Result.failure()
        }
    }
}