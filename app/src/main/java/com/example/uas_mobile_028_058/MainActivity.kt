package com.example.uas_mobile_028_058

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.uas_mobile_028_058.ui.theme.UAS_Mobile_028_058Theme

import androidx.appcompat.app.AppCompatActivity
import android.util.Log

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

import com.example.uas_mobile_028_058.api.ApiClient
import com.example.uas_mobile_028_058.api.ApiService
import com.example.uas_mobile_028_058.models.Event
import com.example.uas_mobile_028_058.models.ApiResponse
import com.example.uas_mobile_028_058.models.Stats

class MainActivity : AppCompatActivity() {

    private val api = ApiClient.instance

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        getAllEvents()
        // createEventExample()
    }

    private fun getAllEvents() {
        api.getAllEvents().enqueue(object : Callback<ApiResponse<List<Event>>> {
            override fun onResponse(
                call: Call<ApiResponse<List<Event>>>,
                response: Response<ApiResponse<List<Event>>>
            ) {
                if (response.isSuccessful) {
                    val events = response.body()?.data
                    Log.d("API", "Events: $events")
                }
            }

            override fun onFailure(call: Call<ApiResponse<List<Event>>>, t: Throwable) {
                Log.e("API", "Error: ${t.message}")
            }
        })
    }

    private fun createEventExample() {
        val event = Event(
            title = "Workshop Kotlin",
            date = "2025-12-01",
            time = "14:00:00",
            location = "Tech Hub Jakarta",
            description = "Belajar Kotlin",
            capacity = 50,
            status = "upcoming"
        )

        api.createEvent(event).enqueue(object : Callback<ApiResponse<Event>> {
            override fun onResponse(
                call: Call<ApiResponse<Event>>,
                response: Response<ApiResponse<Event>>
            ) {
                Log.d("API", "Created: ${response.body()}")
            }

            override fun onFailure(call: Call<ApiResponse<Event>>, t: Throwable) {
                Log.e("API", "Error: ${t.message}")
            }
        })
    }
}
