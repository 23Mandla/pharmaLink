package com.example.pharmalink.api

import retrofit2.http.GET

interface MedicationApiService {

    @GET("medications")
    suspend fun getMedications(): List<String>
}