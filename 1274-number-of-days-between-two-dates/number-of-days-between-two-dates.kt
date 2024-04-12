import java.time.temporal.ChronoUnit.DAYS
import java.time.LocalDate

class Solution {
    fun daysBetweenDates(date1: String, date2: String): Int {
        val d1 = LocalDate.parse(date1)
        val d2 = LocalDate.parse(date2)
        return abs(DAYS.between(d1, d2).toInt())
    }
}