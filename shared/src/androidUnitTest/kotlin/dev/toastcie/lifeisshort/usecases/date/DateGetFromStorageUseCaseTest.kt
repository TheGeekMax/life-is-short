package dev.toastcie.lifeisshort.usecases.date

import dev.toastcie.lifeisshort.repositories.date.IDateRepository
import io.mockk.every
import io.mockk.mockk
import kotlinx.datetime.LocalDate
import kotlin.test.Test
import kotlin.test.assertEquals

class DateGetFromStorageUseCaseTest {

    @Test
    fun testInvokeFromEmpty() {
        val mockkRepository = mockk<IDateRepository>()
        val useCase = GetDateFromStorageUseCase(mockkRepository)

        every {
            mockkRepository.get()
        } returns null

        assertEquals(
            null,
            useCase()
        )
    }

    @Test
    fun testInvoke() {
        val mockkRepository = mockk<IDateRepository>()
        val useCase = GetDateFromStorageUseCase(mockkRepository)

        every {
            mockkRepository.get()
        } returns LocalDate(2021, 1, 1)

        assertEquals(
            LocalDate(2021, 1, 1),
            useCase()
        )
    }
}