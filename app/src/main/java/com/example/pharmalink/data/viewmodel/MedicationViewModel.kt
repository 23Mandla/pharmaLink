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
    val geminiResponse: List<String> = emptyList()
)
class MedicationViewModel(
    private val medicationRepository: MedicationRepository
): ViewModel() {

    private val _medicationState = MutableStateFlow(MedicationState())
    val medicationState: StateFlow<MedicationState> = _medicationState.asStateFlow()

    // Initialize the GenerativeModel with the correct model name
    val model = Firebase.ai(backend = GenerativeBackend.googleAI())
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
                    val geminiSideEffects = askSideEffects()
                    Log.d("askGemini", "getMedication: $geminiSideEffects")

                    _medicationState.update { it.copy(
                        isLoading = false,
                        medication = medications,
                        geminiResponse = geminiSideEffects
                    )
                }
            }catch (e: Exception){
                Log.d("ViewModelError", "Error fetching data: ${e.message}")
                _medicationState.update { it.copy(error = e.message ?: "Unknown error") }

            }

        }
    }

    fun askGemini(question: String) {
        val geminiContext = """
            You are an assistant in a health app.
            Always provide accurate and short answers.
        """.trimIndent()
        viewModelScope.launch {
            val response = model.generateContent("""
                $geminiContext : $question
            """.trimIndent())
            Log.d("TAG", "askGemini: ${response.text}")
        }
    }

    //TODO update the medication state
    private suspend fun askSideEffects(): List<String> {
        val geminiContext = """
            You are an assistant in a health app.
            Always provide accurate and short answers.
        """.trimIndent()

        val response = model.generateContent("""
            $geminiContext
             List 4 common side effects of Paracetamol.
             Return them comma-separated
        """.trimIndent())
        Log.d("TAG", "askGemini: ${response.text}")

        if(!response.text.isNullOrEmpty()){
            val sideEffects = response.text!!
                .trim()
                .split(",")
                .map { it.trim() }

            Log.d("askSideEffects", "askSideEffects: $sideEffects")
            return sideEffects
        }

        return emptyList()
    }
}
