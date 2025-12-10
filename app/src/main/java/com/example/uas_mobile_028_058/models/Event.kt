package com.example.uas_mobile_028_058.models

data class Event(
    val id: String? = null,
    val title: String,
    val date: String,
    val time: String,
    val location: String,
    val description: String? = null,
    val capacity: Int? = null,
    val status: String
)

data class ApiResponse<T>(
    val status: Int,
    val message: String,
    val data: T?,
    val timestamp: String
)

data class Stats(
    val total: String,
    val upcoming: String,
    val ongoing: String,
    val completed: String,
    val cancelled: String
)