package dev.toastcie.lifeisshort.usecases.date

import dev.toastcie.lifeisshort.repositories.date.IDateRepository
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import kotlinx.datetime.LocalDate
import kotlin.test.Test

class DateSetToStorageUseCaseTest {

    @Test
    fun testInvoke() {
        val mockkRepository = mockk<IDateRepository>()
        val useCase = SetDateToStorageUseCase(mockkRepository)

        every {
            mockkRepository.set(LocalDate(2021, 1, 1))
        } returns Unit

        useCase(LocalDate(2021, 1, 1))

        verify { mockkRepository.set(LocalDate(2021, 1, 1)) }
    }
}