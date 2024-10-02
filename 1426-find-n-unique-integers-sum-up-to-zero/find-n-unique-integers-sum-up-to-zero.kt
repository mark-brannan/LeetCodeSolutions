class Solution {
    fun sumZero(n: Int): IntArray {
        val output = IntArray(n) { 0 }
        val half = n / 2

        for (i in 0..(half-1)) {
            output[i] = -(half - i)
            output[n - i - 1] = half - i
        }
        return output
    }
}