package dev.toastcie.lifeisshort.usecases.compute

import kotlinx.datetime.*
import kotlin.test.Test
import kotlin.test.assertEquals

class ComputeWeekConsumedUseCaseTest {

    @Test
    fun testCompute1WeekConsumed() {
        val useCase = ComputeWeekConsumedUseCase()

        assertEquals(
            1,
            useCase(
                Clock.System.now()
                    .minus(1, DateTimeUnit.WEEK, TimeZone.currentSystemDefault())
                    .toLocalDateTime(TimeZone.currentSystemDefault())
                    .date
            )
        )
    }

    @Test
    fun testCompute1YearConsumed() {
        val useCase = ComputeWeekConsumedUseCase()

        assertEquals(
            52,
            useCase(
                Clock.System.now()
                    .minus(1, DateTimeUnit.YEAR, TimeZone.currentSystemDefault())
                    .toLocalDateTime(TimeZone.currentSystemDefault())
                    .date
            )
        )
    }
}