package dev.toastcie.lifeisshort.usecases.date

import dev.toastcie.lifeisshort.repositories.date.IDateRepository
import kotlinx.datetime.LocalDate

class SetDateToStorageUseCase(
    private val dateRepository: IDateRepository
) : ISetDateToStorageUseCase {
    override fun invoke(input: LocalDate) {
        dateRepository.set(input)
    }
}