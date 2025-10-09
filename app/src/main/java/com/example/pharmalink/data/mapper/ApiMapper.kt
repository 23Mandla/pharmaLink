package com.example.pharmalink.data.mapper

import com.example.pharmalink.data.dataclass.Medication
import com.example.pharmalink.data.dto.MedicationDTO

interface ApiMapper<Domain, Entity> {
    fun mapToDomain(entity: MedicationDTO): Medication
    fun mapToEntity(domain: Domain): Entity // map to database entity

}