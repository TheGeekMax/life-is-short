package dev.toastcie.lifeisshort.usecases.date

import dev.toastcie.lifeisshort.repositories.date.IDateRepository
import kotlinx.datetime.LocalDate

class GetDateFromStorageUseCase(
    private val dateRepository: IDateRepository
) : IGetDateFromStorageUseCase {

    override fun invoke(): LocalDate? {
        return dateRepository.get()
    }
}