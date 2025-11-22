package com.example.pharmalink.data.dataclass

data class Medication(
    val dosage: String,
    val medId: Int,
    val medicationName: String,
    val pharmacist: String,
    val prescriptionId: Int,
    val strength: String,
    val sideEffects: List<String> = emptyList()
){
    fun m_name(): String {
        return medicationName
    }

    fun newSideEffects(sideEffects: List<String>): Medication {
        return this.copy(sideEffects = sideEffects)
    }

}
