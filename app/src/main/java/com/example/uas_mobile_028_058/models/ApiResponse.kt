package com.example.uas_mobile_028_058.models

data class ApiResponse<T>(
    val status: Int,
    val message: String,
    val data: T?,
    val timestamp: String
)