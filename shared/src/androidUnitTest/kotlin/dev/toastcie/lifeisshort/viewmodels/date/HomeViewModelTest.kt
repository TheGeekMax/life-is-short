package dev.toastcie.lifeisshort.viewmodels.date

import dev.toastcie.lifeisshort.usecases.compute.IComputeWeekConsumedUseCase
import dev.toastcie.lifeisshort.usecases.date.IGetDateFromStorageUseCase
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import kotlinx.datetime.LocalDate
import kotlin.test.Test
import kotlin.test.assertEquals

class HomeViewModelTest {

    @Test
    fun testCalculateWeekConsumedNoSavedDate() {
        val mockkGetDateFromStorageUseCase = mockk<IGetDateFromStorageUseCase>()
        val mockkComputeWeekConsumedUseCase = mockk<IComputeWeekConsumedUseCase>()

        val homeViewModel = HomeViewModel(
            mockkGetDateFromStorageUseCase,
            mockkComputeWeekConsumedUseCase
        )

        every {
            mockkGetDateFromStorageUseCase()
        } returns null

        homeViewModel.calculateWeekConsumed()

        assertEquals(
            true,
            homeViewModel.onBoardingShown.value
        )

        assertEquals(
            null,
            homeViewModel.bornDate.value
        )
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun testCalculateWeekConsume() = runTest {
        val mockkGetDateFromStorageUseCase = mockk<IGetDateFromStorageUseCase>()
        val mockkComputeWeekConsumedUseCase = mockk<IComputeWeekConsumedUseCase>()

        val homeViewModel = HomeViewModel(
            mockkGetDateFromStorageUseCase,
            mockkComputeWeekConsumedUseCase
        )

        backgroundScope.launch(UnconfinedTestDispatcher(testScheduler)) {
            homeViewModel.weekConsumed.collect { _ -> }
        }

        every {
            mockkGetDateFromStorageUseCase()
        } returns LocalDate(2021, 1, 1)

        every {
            mockkComputeWeekConsumedUseCase(LocalDate(2021, 1, 1))
        } returns 1

        homeViewModel.calculateWeekConsumed()

        //verify {
        //    mockkComputeWeekConsumedUseCase(LocalDate(2021, 1, 1))
        //}

        assertEquals(
            false,
            homeViewModel.onBoardingShown.value
        )

        assertEquals(
            LocalDate(2021, 1, 1),
            homeViewModel.bornDate.value
        )

        //assertEquals(
        //    1,
        //    homeViewModel.weekConsumed.value
        //)
    }
}