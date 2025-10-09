package com.example.pharmalink.data.repository

import com.example.pharmalink.data.dataclass.Medication
import com.example.pharmalink.data.dto.MedicationDTO

interface MedicationRepository {
    suspend fun getMedication(apiKey: String): List<Medication>
}