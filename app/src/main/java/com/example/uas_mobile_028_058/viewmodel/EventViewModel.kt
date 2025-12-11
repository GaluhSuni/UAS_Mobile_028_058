package com.example.uas_mobile_028_058.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.uas_mobile_028_058.api.ApiClient
import com.example.uas_mobile_028_058.api.ApiService
import com.example.uas_mobile_028_058.models.Event
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class EventViewModel : ViewModel() {

    // buat service dari ApiClient.retrofit
    private val api = ApiClient.retrofit.create(ApiService::class.java)

    private val _events = MutableStateFlow<List<Event>>(emptyList())
    val events: StateFlow<List<Event>> get() = _events

    init {
        loadEvents()
    }

    fun loadEvents() {
        viewModelScope.launch {
            try {
                // panggil di IO dispatcher
                val response = withContext(Dispatchers.IO) {
                    api.getAllEvents()
                }
                if (response.isSuccessful) {
                    val body = response.body()
                    body?.data?.let { _events.value = it }
                } else {
                    // bisa log atau set state error
                }
            } catch (e: Exception) {
                // tangani network error
            }
        }
    }

    // createEvent sekarang menerima optional description & capacity
    fun createEvent(
        title: String,
        date: String,
        time: String,
        location: String,
        status: String,
        description: String? = null,
        capacity: Int? = null
    ) {
        viewModelScope.launch {
            try {
                val newEvent = Event(
                    id = null,
                    title = title,
                    date = date,
                    time = time,
                    location = location,
                    status = status,
                    description = description,
                    capacity = capacity
                )

                val response = withContext(Dispatchers.IO) {
                    api.createEvent(newEvent)
                }

                if (response.isSuccessful) {
                    // reload list setelah sukses
                    loadEvents()
                } else {
                    // tangani error (response.errorBody())
                }
            } catch (e: Exception) {
                // tangani exception
            }
        }
    }

    // contoh fungsi update/delete bisa ditambahkan di sini
    fun navigateToCreate() {
        // placeholder untuk navigasi (implementasikan Compose Navigation kalau perlu)
    }
}

//class EventViewModel : ViewModel() {
//
//    private val api = ApiClient.instance.create(ApiService::class.java)
//
//    private val _events = MutableStateFlow<List<Event>>(emptyList())
//    val events: StateFlow<List<Event>> get() = _events
//
//    init {
//        loadEvents()
//    }
//
//    fun loadEvents() {
//        viewModelScope.launch {
//            val response = api.getAllEvents().execute()
//            response.body()?.data?.let { _events.value = it }
//        }
//    }
//
//    fun createEvent(title: String, date: String, time: String, location: String, status: String) {
//        viewModelScope.launch {
//            val newEvent = Event(
//                title = title,
//                date = date,
//                time = time,
//                location = location,
//                status = status
//            )
//            api.createEvent(newEvent).execute()
//            loadEvents()
//        }
//    }
//
//    fun navigateToCreate() {}
//}
