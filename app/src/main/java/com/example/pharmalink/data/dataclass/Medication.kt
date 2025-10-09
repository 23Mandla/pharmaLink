package com.example.pharmalink.data.dataclass

data class Medication(
    val dosage: String,
    val medId: Int,
    val medicationName: String,
    val pharmacist: String,
    val prescriptionId: Int,
    val strength: String
)
