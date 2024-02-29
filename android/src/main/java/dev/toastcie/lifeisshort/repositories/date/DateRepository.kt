package dev.toastcie.lifeisshort.repositories.date

import android.content.Context
import kotlinx.datetime.LocalDate
import kotlinx.datetime.toLocalDate

class DateRepository(
    private val context: Context
) : IDateRepository {
    private val sharedPreferences = context.getSharedPreferences("date", Context.MODE_PRIVATE)
    override fun get(): LocalDate? = sharedPreferences.getString("date", null)?.toLocalDate()

    override fun set(date: LocalDate) {
        sharedPreferences.edit().putString("date", date.toString()).apply()
    }
}