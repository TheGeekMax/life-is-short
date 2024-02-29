package dev.toastcie.lifeisshort.repositories.date

import android.content.Context
import kotlinx.datetime.LocalDate

class DateRepository(
    private val context: Context
) : IDateRepository {
    private val sharedPreferences = context.getSharedPreferences("date", Context.MODE_PRIVATE)
    override fun get(): LocalDate? {
        val date = sharedPreferences.getString("date", null)
        return if (date != null) {
            LocalDate.parse(date)
        } else {
            null
        }
    }

    override fun set(date: LocalDate) {
        sharedPreferences.edit().putString("date", date.toString()).apply()
    }
}