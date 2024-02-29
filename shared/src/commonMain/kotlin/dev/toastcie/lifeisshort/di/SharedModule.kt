package dev.toastcie.lifeisshort.di

import dev.toastcie.lifeisshort.usecases.compute.ComputeWeekConsumedUseCase
import dev.toastcie.lifeisshort.usecases.compute.IComputeWeekConsumedUseCase
import dev.toastcie.lifeisshort.usecases.date.GetDateFromStorageUseCase
import dev.toastcie.lifeisshort.usecases.date.IGetDateFromStorageUseCase
import dev.toastcie.lifeisshort.usecases.date.ISetDateToStorageUseCase
import dev.toastcie.lifeisshort.usecases.date.SetDateToStorageUseCase
import org.koin.dsl.module

val useCaseModule = module {
    single<IGetDateFromStorageUseCase> { GetDateFromStorageUseCase(get()) }
    single<ISetDateToStorageUseCase> { SetDateToStorageUseCase(get()) }
    single<IComputeWeekConsumedUseCase> { ComputeWeekConsumedUseCase() }
}

val sharedModule = listOf(
    useCaseModule,
    platformModule()
)