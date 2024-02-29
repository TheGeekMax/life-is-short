package dev.toastcie.lifeisshort.usecases.date

import kotlinx.datetime.LocalDate
import me.nathanfallet.usecases.base.IUseCase

interface ISetDateToStorageUseCase : IUseCase<LocalDate, Unit>