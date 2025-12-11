package com.example.uas_mobile_028_058.api

import com.example.uas_mobile_028_058.models.ApiResponse
import com.example.uas_mobile_028_058.models.Event
import com.example.uas_mobile_028_058.models.Stats
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

//EventApiService

interface ApiService {

    @GET("api.php")
    suspend fun getAllEvents(): Response<ApiResponse<List<Event>>>

    @GET("api.php")
    suspend fun getEventById(@Query("id") id: Int): Response<ApiResponse<Event>>

    @POST("api.php")
    suspend fun createEvent(@Body event: Event): Response<ApiResponse<Event>>

    @PUT("api.php")
    suspend fun updateEvent(@Query("id") id: Int, @Body event: Event): Response<ApiResponse<Event>>

    @DELETE("api.php")
    suspend fun deleteEvent(@Query("id") id: Int): Response<ApiResponse<Event>>
}

//interface ApiService {
//
//    @GET("api.php")
//    fun getAllEvents(): Call<ApiResponse<List<Event>>>
//
//    @GET("api.php")
//    fun getEventById(
//        @Query("id") id: Int
//    ): Call<ApiResponse<Event>>
//
//    @GET("api.php")
//    fun getEventsByDate(
//        @Query("date") date: String
//    ): Call<ApiResponse<List<Event>>>
//
//    @GET("api.php")
//    fun getEventsByDateRange(
//        @Query("date_from") from: String,
//        @Query("date_to") to: String
//    ): Call<ApiResponse<List<Event>>>
//
//    @GET("api.php")
//    fun getEventsByStatus(
//        @Query("status") status: String,
//    ): Call<ApiResponse<List<Event>>>
//
//    @GET("api.php")
//    fun getStatistics(
//        @Query("stats") stats: Int = 1
//    ): Call<ApiResponse<Stats>>
//
//    @POST("api.php")
//    fun createEvent(
//        @Body body: Event
//    ): Call<ApiResponse<Event>>
//
//    @PUT("api.php")
//    fun updateEvent(
//        @Query("id") id: Int,
//        @Body body: Event
//    ): Call<ApiResponse<Event>>
//
//    @DELETE("api.php")
//    fun deleteEvent(
//        @Query("id") id: Int
//    ): Call<ApiResponse<String>>
//}
