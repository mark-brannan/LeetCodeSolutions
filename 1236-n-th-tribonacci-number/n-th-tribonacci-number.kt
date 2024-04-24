class Solution {
    private val values = IntArray(38)
    init {
        values[0] = 0
        values[1] = 1
        values[2] = 1
        for (i in 3..37) {
            values[i] = values[i-1] + values[i-2] + values[i-3]
        }
    }

    fun tribonacci(n: Int): Int {
        return values[n]
    }


}