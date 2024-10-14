class Solution {
    fun isHappy(n: Int): Boolean {
        var next = n
        val priorValues = mutableListOf(n)
        while (true) {
            next = next.happyIteration()
            when (next) {
                1 -> return true
                in priorValues -> return false
            }
            priorValues.add(next)
        }
    }

    fun Int.happyIteration() = this.toString()
        .map { it.digitToInt() }
        .map { it * it }
        .sum()
}
