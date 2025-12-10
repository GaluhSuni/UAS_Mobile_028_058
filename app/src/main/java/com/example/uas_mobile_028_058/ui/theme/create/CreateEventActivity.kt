package com.example.uas_mobile_028_058.ui.theme.create

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.uas_mobile_028_058.api.ApiClient
import com.example.uas_mobile_028_058.api.ApiService
//import com.example.uas_mobile_028_058.databinding.ActivityCreateEventBinding
import com.example.uas_mobile_028_058.models.ApiResponse
import com.example.uas_mobile_028_058.models.Event
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CreateEventActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCreateEventBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateEventBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSave.setOnClickListener {
            createEvent()
        }
    }

    private fun createEvent() {

        val event = Event(
            title = binding.etTitle.text.toString(),
            date = binding.etDate.text.toString(),
            time = binding.etTime.text.toString(),
            location = binding.etLocation.text.toString(),
            status = binding.etStatus.text.toString(),        // wajib
            description = binding.etDesc.text.toString().ifEmpty { null },
            capacity = binding.etCapacity.text.toString().toIntOrNull()
        )


        val service = ApiClient.instance.create(EventApiService::class.java)
        service.createEvent(event).enqueue(object : Callback<ApiResponse<Event>> {
            override fun onResponse(
                call: Call<ApiResponse<Event>>,
                response: Response<ApiResponse<Event>>
            ) {
                Toast.makeText(this@CreateEventActivity, response.body()?.message, Toast.LENGTH_LONG)
                    .show()
                finish()
            }

            override fun onFailure(call: Call<ApiResponse<Event>>, t: Throwable) {
                Toast.makeText(this@CreateEventActivity, t.message, Toast.LENGTH_LONG).show()
            }
        })
    }
}
