package com.example.pharmalink.data.repository

import com.example.pharmalink.api.MedicationApiService
import com.example.pharmalink.data.dataclass.Medication
import com.example.pharmalink.data.dto.MedicationDTO
import com.example.pharmalink.data.mapper.ApiMapper

class MedicationImpl(
    private val apiService: MedicationApiService,
    private val mapper: ApiMapper<Medication, MedicationDTO>
): MedicationRepository {
    override suspend fun getMedication(apiKey: String): List<Medication> {
        val response = apiService.getMedications(apiKey)
        return response.map { mapper.mapToDomain(it) }
    }
}