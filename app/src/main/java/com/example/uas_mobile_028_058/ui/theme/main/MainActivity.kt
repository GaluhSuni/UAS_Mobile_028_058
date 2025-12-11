package com.example.uas_mobile_028_058.ui.theme.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            EventListScreen()
        }
    }
}


//class MainActivity : AppCompatActivity() {
//
//    private lateinit var binding: ActivityMainBinding
//    private lateinit var adapter: EventAdapter
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        adapter = EventAdapter(emptyList())
//        binding.recyclerView.layoutManager = LinearLayoutManager(this)
//        binding.recyclerView.adapter = adapter
//
//        binding.fabAdd.setOnClickListener {
//            startActivity(Intent(this, CreateEventActivity::class.java))
//        }
//
//        loadEvents()
//    }
//
//    override fun onResume() {
//        super.onResume()
//        loadEvents()
//    }
//
//    private fun loadEvents() {
//        val service = ApiClient.instance.create(EventApiService::class.java)
//        service.getAllEvents().enqueue(object : Callback<ApiResponse<List<Event>>> {
//            override fun onResponse(
//                call: Call<ApiResponse<List<Event>>>,
//                response: Response<ApiResponse<List<Event>>>
//            ) {
//                if (response.isSuccessful && response.body()?.data != null) {
//                    adapter.updateData(response.body()!!.data!!)
//                } else {
//                    Toast.makeText(this@MainActivity, "Gagal memuat data", Toast.LENGTH_SHORT).show()
//                }
//            }
//
//            override fun onFailure(call: Call<ApiResponse<List<Event>>>, t: Throwable) {
//                Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_LONG).show()
//            }
//        })
//    }
//}


//class MainActivity : AppCompatActivity() {
//
//    private val api = ApiClient.instance
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        getAllEvents()
//        // createEventExample()
//    }
//
//    private fun getAllEvents() {
//        api.getAllEvents().enqueue(object : Callback<ApiResponse<List<Event>>> {
//            override fun onResponse(
//                call: Call<ApiResponse<List<Event>>>,
//                response: Response<ApiResponse<List<Event>>>
//            ) {
//                if (response.isSuccessful) {
//                    val events = response.body()?.data
//                    Log.d("API", "Events: $events")
//                }
//            }
//
//            override fun onFailure(call: Call<ApiResponse<List<Event>>>, t: Throwable) {
//                Log.e("API", "Error: ${t.message}")
//            }
//        })
//    }
//
//    private fun createEventExample() {
//        val event = Event(
//            title = "Workshop Kotlin",
//            date = "2025-12-01",
//            time = "14:00:00",
//            location = "Tech Hub Jakarta",
//            description = "Belajar Kotlin",
//            capacity = 50,
//            status = "upcoming"
//        )
//
//        api.createEvent(event).enqueue(object : Callback<ApiResponse<Event>> {
//            override fun onResponse(
//                call: Call<ApiResponse<Event>>,
//                response: Response<ApiResponse<Event>>
//            ) {
//                Log.d("API", "Created: ${response.body()}")
//            }
//
//            override fun onFailure(call: Call<ApiResponse<Event>>, t: Throwable) {
//                Log.e("API", "Error: ${t.message}")
//            }
//        })
//    }
//}

//private fun updateEvent() {
//    val updated = Event(
//        title = "Workshop Kotlin Advanced",
//        date = "2025-12-02",
//        time = "10:00:00",
//        location = "Jakarta Convention Center",
//        description = "Materi lanjutan",
//        capacity = 80,
//        status = "ongoing"
//    )
//
//    api.updateEvent(1, updated).enqueue(object : Callback<ApiResponse<Event>> {
//        override fun onResponse(
//            call: Call<ApiResponse<Event>>,
//            response: Response<ApiResponse<Event>>
//        ) {
//            Log.d("API", "Updated: ${response.body()}")
//        }
//
//        override fun onFailure(call: Call<ApiResponse<Event>>, t: Throwable) {
//            Log.e("API", "Error: ${t.message}")
//        }
//    })
//}

//private fun deleteEvent() {
//    api.deleteEvent(1).enqueue(object : Callback<ApiResponse<String>> {
//        override fun onResponse(
//            call: Call<ApiResponse<String>>,
//            response: Response<ApiResponse<String>>
//        ) {
//            Log.d("API", "Deleted: ${response.body()?.message}")
//        }
//
//        override fun onFailure(call: Call<ApiResponse<String>>, t: Throwable) {
//            Log.e("API", "Error: ${t.message}")
//        }
//    })
//}
