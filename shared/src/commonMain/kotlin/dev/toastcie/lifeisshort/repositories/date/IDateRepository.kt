package dev.toastcie.lifeisshort.repositories.date

import kotlinx.datetime.LocalDate

interface IDateRepository {
    fun get(): LocalDate?
    fun set(date: LocalDate)
}