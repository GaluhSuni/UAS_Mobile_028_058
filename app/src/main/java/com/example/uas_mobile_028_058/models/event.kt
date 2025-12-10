package com.example.uas_mobile_028_058.models

//import android.icu.text.DateFormat
//import com.google.firebase.sessions.Time
import java.sql.Time

data class Event(
    val id: Int? = null,          // auto-increment, nullable
    val title: String,            // required
    val date: String,             // required YYYY-MM-DD
    val time: String,             // required HH:MM:SS
    val location: String,         // required
    val status: String,           // required (enum)
    val description: String? = null,  // optional
    val capacity: Int? = null         // optional
)

data class Stats(
    val total: Int,
    val upcoming: Int,
    val ongoing: Int,
    val completed: Int,
    val cancelled: Int
)
