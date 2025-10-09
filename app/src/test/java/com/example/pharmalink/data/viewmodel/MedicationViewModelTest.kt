package com.example.pharmalink.data.viewmodel

import com.example.pharmalink.api.MedicationApiService
import com.example.pharmalink.data.dataclass.Medication
import com.example.pharmalink.data.dto.MedicationDTO
import com.example.pharmalink.data.mapper.ApiMapper
import com.example.pharmalink.data.repository.MedicationImpl
import kotlinx.coroutines.runBlocking
import org.junit.Before
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

    @Test
    fun `Successful medication fetch and state update`() {
        // Mock the medicationRepository to return a successful response with a list of medications. 
        // Verify that medicationState is updated with isLoading as false and the correct medication list.
        // TODO implement test
    }

    @Test
    fun `Successful medication fetch with an empty list`() {
        // Mock the medicationRepository to return an empty list of medications. 
        // Verify that medicationState is updated with isLoading as false and an empty medication list.
        // TODO implement test
    }

    @Test
    fun `Repository throws a generic exception`() {
        // Mock the medicationRepository to throw a generic Exception. 
        // Verify that medicationState is updated with the corresponding error message and isLoading remains false.
        // TODO implement test
    }

    @Test
    fun `Repository throws an exception with a null message`() {
        // Mock the medicationRepository to throw an Exception with a null message. 
        // Verify that medicationState is updated with the default 'Unknown error' message.
        // TODO implement test
    }

    @Test
    fun `Repository throws a specific network exception  e g   IOException `() {
        // Mock the medicationRepository to throw an IOException. 
        // Verify that the medicationState is updated with the specific error message from the exception.
        // TODO implement test
    }

    @Test
    fun `ViewModel initialization triggers data fetch`() {
        // Verify that the getMedication function is called automatically when the ViewModel is initialized.
        // TODO implement test
    }

    @Test
    fun `Coroutine cancellation during fetch`() {
        // Launch the getMedication function and then immediately cancel the viewModelScope. 
        // Verify that the state does not proceed to the success or error state and remains in a consistent state (likely loading or initial).
        // TODO implement test
    }

    @Test
    fun `Multiple rapid initializations`() {
        // Create multiple instances of the ViewModel in quick succession. 
        // Verify that each instance handles its state correctly without interfering with others, although this is more of an integration concern.
        // TODO implement test
    }

}