class Solution {
    fun isPalindrome(x: Int): Boolean {
        return when {
            x < 0 -> false
            x < 10 -> true
            x % 10 == 0 -> false
            else -> x.toString().let { it == it.reversed() }
        }
    }
}