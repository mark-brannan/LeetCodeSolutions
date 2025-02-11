class Solution {
    fun isPalindrome(x: Int): Boolean {
        return when {
            x < 0 -> false
            x < 10 -> true // optimization for single digit ints
            x > 1000000000 && x.toString().reversed().toDouble() > Int.MAX_VALUE -> false
            else -> {
                val xPrime = x.toString().reversed().toInt()
                x == xPrime
            }
        }
    }
}