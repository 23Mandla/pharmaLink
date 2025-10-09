package com.example.pharmalink.api

import com.example.pharmalink.data.dto.MedicationDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface MedicationApiService {

    @GET("Medication.json")
    suspend fun getMedications(
        @Query("key") apiKey: String
    ): List<MedicationDTO>
}