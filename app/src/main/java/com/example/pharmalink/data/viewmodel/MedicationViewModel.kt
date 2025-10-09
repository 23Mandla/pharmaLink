package com.example.pharmalink.data.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pharmalink.data.dataclass.Medication
import com.example.pharmalink.data.repository.MedicationRepository
import com.example.pharmalink.data.retroClient.InternetService
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

data class MedicationState (
    val isLoading: Boolean = false,
    val medication: List<Medication> = emptyList(),
    val error: String = ""
)
class MedicationViewModel(
    private val medicationRepository: MedicationRepository
): ViewModel() {

    private val _medicationState = MutableStateFlow(MedicationState())
    val medicationState: StateFlow<MedicationState> = _medicationState.asStateFlow()

    init {
        getMedication()
    }

    private fun getMedication(){
        viewModelScope.launch {
            _medicationState.update { it.copy(isLoading = true) }
            try {
                val medications = medicationRepository.getMedication(InternetService.API_KEY)
                _medicationState.update { it.copy(
                    isLoading = false,
                    medication = medications
                )
                }
            }catch (e: Exception){
                _medicationState.update { it.copy(error = e.message ?: "Unknown error") }

            }
        }
    }
}