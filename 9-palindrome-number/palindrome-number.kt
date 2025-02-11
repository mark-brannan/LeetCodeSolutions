class Solution {
    fun isPalindrome(x: Int): Boolean {
        val reverse = x.toString().reversed()
        return when {
            x < 0 -> false
            reverse.toDouble() > Int.MAX_VALUE -> false
            else -> x == reverse.toInt()
        }
    }
}