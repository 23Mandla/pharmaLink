package com.example.pharmalink.data.repository

import com.example.pharmalink.api.MedicationApiService
import com.example.pharmalink.data.dataclass.Medication
import com.example.pharmalink.data.dto.MedicationDTO
import com.example.pharmalink.data.mapper.ApiMapper
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`

class MedicationImplTest {


    private val apiService: MedicationApiService = mock()
    private val mapper: ApiMapper<Medication, MedicationDTO> = mock()
    private lateinit var medicationRepository: MedicationImpl

    @Before
    fun setUp() {
        medicationRepository = MedicationImpl(
            apiService,
            mapper
        )
    }

    @Test
    fun getMedications(){

        val medicationDTO = MedicationDTO(
            "Every 48 hours",
            1,
            "Bisoprolol",
            "Ashla",
            228,
            "20 mg"
        )

        val medication = Medication(
            "Every 48 hours",
            1,
            "Bisoprolol",
            "Ashla",
            228,
            "20 mg"
        )

        `when`(
            runBlocking {
                apiService.getMedications("testApi")
        })
            .thenReturn(listOf(medicationDTO))

        `when`(
            mapper.mapToDomain(medicationDTO)
        )
            .thenReturn(medication)

        runBlocking {
            val result = medicationRepository.getMedication("testApi")
            assertEquals(result, listOf(medication))
        }
    }
}