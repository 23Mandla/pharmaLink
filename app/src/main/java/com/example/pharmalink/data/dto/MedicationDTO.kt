package com.example.pharmalink.data.dto

import com.google.gson.annotations.SerializedName

data class MedicationDTO(
    @SerializedName("dosage")
    val dosage: String,
    @SerializedName("med_id")
    val medId: Int,
    @SerializedName("medication_name")
    val medicationName: String,
    @SerializedName("pharmacist")
    val pharmacist: String,
    @SerializedName("prescription_id")
    val prescriptionId: Int,
    @SerializedName("strength")
    val strength: String
)