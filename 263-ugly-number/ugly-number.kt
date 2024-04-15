class Solution {
    fun isUgly(n: Int): Boolean {
        if (n == 1) return true
        if (n <= 0) return false
        var k = n
        while (k >= 1) {
            when {
                k in listOf(2,3,5) -> return true
                (k % 2 == 0) -> k = k / 2
                (k % 3 == 0) -> k = k / 3
                (k % 5 == 0) -> k = k / 5
                else -> return false
            }
        }
        return true
    }
}