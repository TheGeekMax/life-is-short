package dev.toastcie.lifeisshort.di

import dev.toastcie.lifeisshort.usecases.date.GetDateFromStorageUseCase
import dev.toastcie.lifeisshort.usecases.date.IGetDateFromStorageUseCase
import org.koin.dsl.module

val repositoryModule = module {
}

val useCaseModule = module {
    single<IGetDateFromStorageUseCase> { GetDateFromStorageUseCase(get()) }
}

val sharedModule = listOf(
    repositoryModule,
    useCaseModule,
    platformModule()
)