class Solution {
    fun countStudents(students: IntArray, sandwiches: IntArray): Int {
        val studentsQueue = ArrayDeque<Int>(students.toList())
        val sandwichesStack = ArrayDeque<Int>(sandwiches.toList())
        return doLunch(studentsQueue, sandwichesStack)
    }

    internal fun doLunch(students: ArrayDeque<Int>, sandwiches: ArrayDeque<Int>): Int {
        var noTakersCount = 0 
        while (students.isNotEmpty() && noTakersCount <= students.size) {
            System.out.print("students=$students, sandwiches=$sandwiches ...")
            val student = students.removeFirst()
            val sandwich = sandwiches.first()
            when {
                (student == sandwich) -> {
                    System.out.println("$student takes it.")
                    sandwiches.removeFirst()
                    noTakersCount = 0
                }
                else -> {
                    System.out.println("$student gets back in line.")
                    // move first to end of the line (add last)
                    students.add(student)
                    ++noTakersCount
                }
            }
        }
        return students.size
    }
}