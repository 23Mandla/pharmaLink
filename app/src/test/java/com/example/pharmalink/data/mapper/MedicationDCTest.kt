package com.example.pharmalink.data.mapper

import com.example.pharmalink.data.dataclass.Medication
import com.example.pharmalink.data.dto.MedicationDTO
import org.junit.Test
import org.mockito.kotlin.whenever

class MedicationDCTest {

    private val mapper = MedicationDC()
    private val medication = Medication(
        dosage = "Every 48 hours",
        medId = 1,
        medicationName = "Bisoprolol",
        pharmacist = "Ashla",
        prescriptionId = 228,
        strength = "20 mg"
    )

    private val medicationDTO = MedicationDTO(
        dosage = "Every 48 hours",
        medId = 1,
        medicationName = "Bisoprolol",
        pharmacist = "Ashla",
        prescriptionId = 228,
        strength = "20 mg"
    )

    @Test
    fun successfulMapping() {
        whenever(
            mapper.mapToDomain(medicationDTO)
        )
            .thenReturn(medication)
        assert(mapper.mapToDomain(medicationDTO) == medication)

    }

    @Test
    fun mapWithSpecialCharactersInStrings() {

        // TODO
        // Verify that string fields can handle a wide range of special characters,
        // including Unicode and symbols, without data loss or corruption. [10, 14]
        // when string fields are populated with very long strings
        // Include all edge cases that aren't suppose to be a response

    }
}