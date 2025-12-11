package com.example.uas_mobile_028_058.ui.theme.create

//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.widget.Toast
//import com.example.uas_mobile_028_058.api.ApiClient
//import com.example.uas_mobile_028_058.api.ApiService
//import com.example.uas_mobile_028_058.models.ApiResponse
//import com.example.uas_mobile_028_058.models.Event
//import retrofit2.Call
//import retrofit2.Callback
//import retrofit2.Response

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.uas_mobile_028_058.viewmodel.EventViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateEventScreen(
    viewModel: EventViewModel = EventViewModel()
) {
    var title by remember { mutableStateOf("") }
    var date by remember { mutableStateOf("") }
    var time by remember { mutableStateOf("") }
    var location by remember { mutableStateOf("") }
    var status by remember { mutableStateOf("upcoming") }
    var description by remember { mutableStateOf("") }
    var capacity by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Create Event") }
            )
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {

            OutlinedTextField(
                value = title,
                onValueChange = { title = it },
                label = { Text("Title") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = date,
                onValueChange = { date = it },
                label = { Text("Date (YYYY-MM-DD)") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = time,
                onValueChange = { time = it },
                label = { Text("Time (HH:MM:SS)") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = location,
                onValueChange = { location = it },
                label = { Text("Location") },
                modifier = Modifier.fillMaxWidth()
            )

            // Status Dropdown (Material3)
            ExposedDropdownMenuBox(
                expanded = false,
                onExpandedChange = {}
            ) {}

            OutlinedTextField(
                value = description,
                onValueChange = { description = it },
                label = { Text("Description (optional)") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = capacity,
                onValueChange = { capacity = it },
                label = { Text("Capacity (optional)") },
                modifier = Modifier.fillMaxWidth(),
            )

            Spacer(Modifier.height(20.dp))

            Button(
                onClick = {
                    viewModel.createEvent(
                        title = title,
                        date = date,
                        time = time,
                        location = location,
                        status = status,
                        description = description.ifEmpty { null },
                        capacity = capacity.toIntOrNull()
                    )
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Save Event")
            }
        }
    }
}



//class CreateEventScreen : AppCompatActivity() {
//
//    private lateinit var binding: ActivityCreateEventBinding
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityCreateEventBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        binding.btnSave.setOnClickListener {
//            createEvent()
//        }
//    }
//
//    private fun createEvent() {
//
//        val event = Event(
//            title = binding.etTitle.text.toString(),
//            date = binding.etDate.text.toString(),
//            time = binding.etTime.text.toString(),
//            location = binding.etLocation.text.toString(),
//            status = binding.etStatus.text.toString(),        // wajib
//            description = binding.etDesc.text.toString().ifEmpty { null },
//            capacity = binding.etCapacity.text.toString().toIntOrNull()
//        )
//
//
//        val service = ApiClient.instance.create(ApiService::class.java)
//        service.createEvent(event).enqueue(object : Callback<ApiResponse<Event>> {
//            override fun onResponse(
//                call: Call<ApiResponse<Event>>,
//                response: Response<ApiResponse<Event>>
//            ) {
//                Toast.makeText(this@CreateEventScreen, response.body()?.message, Toast.LENGTH_LONG)
//                    .show()
//                finish()
//            }
//
//            override fun onFailure(call: Call<ApiResponse<Event>>, t: Throwable) {
//                Toast.makeText(this@CreateEventScreen, t.message, Toast.LENGTH_LONG).show()
//            }
//        })
//    }
//}
