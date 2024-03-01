package dev.toastcie.lifeisshort.di

import dev.toastcie.lifeisshort.repositories.date.DateRepository
import dev.toastcie.lifeisshort.repositories.date.IDateRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<IDateRepository> { DateRepository(get()) }
}

val androidModule = listOf(
    repositoryModule,
)