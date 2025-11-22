package com.example.pharmalink.data.mapper

import com.example.pharmalink.data.dataclass.Medication
import com.example.pharmalink.data.dto.MedicationDTO

class MedicationDC : ApiMapper<Medication, MedicationDTO> {

    //TODO each medication should get its own response from Gemini
    override fun mapToDomain(entity: MedicationDTO): Medication {
        return Medication(
            dosage = entity.dosage,
            medId = entity.medId,
            medicationName = entity.medicationName,
            pharmacist = entity.pharmacist,
            prescriptionId = entity.prescriptionId,
            strength = entity.strength,
            sideEffects = emptyList()
        )
    }

    override fun mapToEntity(domain: Medication): MedicationDTO {
        TODO("To data base")
    }

}