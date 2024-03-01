package dev.toastcie.lifeisshort.usecases.compute

import kotlinx.datetime.LocalDate
import me.nathanfallet.usecases.base.IUseCase

interface IComputeWeekConsumedUseCase : IUseCase<LocalDate, Int>