package com.example.pharmalink.data.viewmodel

import android.util.Log
import androidx.compose.ui.semantics.text
import androidx.lifecycle.ViewModel

import androidx.lifecycle.viewModelScope
import com.example.pharmalink.data.dataclass.Medication
import com.example.pharmalink.data.repository.MedicationRepository
import com.example.pharmalink.data.retroClient.InternetService
import com.google.firebase.Firebase
import com.google.firebase.ai.ai
import com.google.firebase.ai.type.GenerativeBackend
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

data class MedicationState (
    val isLoading: Boolean = false,
    val medication: List<Medication> = emptyList(),
    val error: String = "",
    val geminiResponse: String = ""
)
class MedicationViewModel(
    private val medicationRepository: MedicationRepository
): ViewModel() {

    private val _medicationState = MutableStateFlow(MedicationState())
    val medicationState: StateFlow<MedicationState> = _medicationState.asStateFlow()

    // Initialize the GenerativeModel with the correct model name
    val model = Firebase.ai(backend= GenerativeBackend.googleAI())
        .generativeModel("gemini-2.0-flash")

    init {
        getMedication()
    }

    //For testing purposes
    private fun getHardCodedMedication(){
        _medicationState.update {
            it.copy(
                isLoading = false,
                medication = listOf(
                    Medication(
                        "Every evening",
                        1,
                        "Diazepam",
                        "Dev",
                        731,
                        "10 mg"
                    ),
                    Medication(
                        "4 times a day",
                        1,
                        "Paracetamol",
                        "Dev",
                        731,
                        "10 mg"
                    ),
                    Medication(
                        "Every evening",
                        1,
                        "Ibuprofen",
                        "Dev",
                        731,
                        "10 mg"
                    )
                )
            )
        }
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

    fun askGemini(question: String) {
        viewModelScope.launch {
            val response = model.generateContent(question)
            Log.d("TAG", "askGemini: ${response.text}")
        }
    }
}
