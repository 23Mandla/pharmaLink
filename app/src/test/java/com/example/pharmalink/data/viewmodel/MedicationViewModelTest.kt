package com.example.pharmalink.data.viewmodel

import com.example.pharmalink.api.MedicationApiService
import com.example.pharmalink.data.dataclass.Medication
import com.example.pharmalink.data.dto.MedicationDTO
import com.example.pharmalink.data.mapper.ApiMapper
import com.example.pharmalink.data.repository.MedicationImpl
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Ignore
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`

class MedicationViewModelTest {

    private val apiService: MedicationApiService = mock()
    private val mapper: ApiMapper<Medication, MedicationDTO> = mock()
    private lateinit var medicationRepository: MedicationImpl
    private lateinit var viewModel: MedicationViewModel

    @Before
    fun setUp() {
        medicationRepository = MedicationImpl(
            apiService,
            mapper
        )

        viewModel = MedicationViewModel(
            medicationRepository
        )
    }

    @Test
    fun initialStateCheck() {

        val state = viewModel.medicationState.value.isLoading
        val result = viewModel.medicationState.value.medication
        val error = viewModel.medicationState.value.error

        assert(!state)
        assert(result.isEmpty())
        assert(error.isEmpty())

    }

    @Test
    fun loadingState() {

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

        val state = viewModel.medicationState.value.isLoading
        val result = viewModel.medicationState.value.medication
        val error = viewModel.medicationState.value.error

        println(state)
        println(result)
        println(error)

        assert(state)
        assert(error.isNotEmpty())

    }

    @Ignore("To be implemented")
    @Test
    fun fetchAndStateUpdate() {
        // TODO
        // Mock the medicationRepository to return a successful response with a list of medications. 
        // Verify that medicationState is updated with isLoading as false and the correct medication list.

    }

    @Ignore("To be implemented")
    @Test
    fun emptyListMedication() {
        // TODO
        // Mock the medicationRepository to return an empty list of medications. 
        // Verify that medicationState is updated with isLoading as false and an empty medication list.

    }

    @Ignore("To be implemented")
    @Test
    fun repositoryGenericException() {
        // TODO
        // Mock the medicationRepository to throw a generic Exception. 
        // Verify that medicationState is updated with the corresponding error message and isLoading remains false.
        //network and null exceptions
    }

    @Ignore("To be implemented")
    @Test
    fun coroutineFetchCancellation() {

        // TODO
        // Launch the getMedication function and then immediately cancel the viewModelScope. 
        // Verify that the state does not proceed to the success or error state and remains in a consistent state (likely loading or initial).

    }


}