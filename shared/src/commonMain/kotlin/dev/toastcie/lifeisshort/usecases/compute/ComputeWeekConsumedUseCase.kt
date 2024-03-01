package dev.toastcie.lifeisshort.usecases.compute

import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDate
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

class ComputeWeekConsumedUseCase : IComputeWeekConsumedUseCase {

    override fun invoke(input: LocalDate): Int {
        val now = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault()).date
        val nowWeekCount = now.year * 52 + (now.dayOfYear / 7)
        val inputWeekCount = input.year * 52 + (input.dayOfYear / 7)
        return nowWeekCount - inputWeekCount
    }
}