class Solution {
    fun isPalindrome(s: String): Boolean {
        val normalized = s.lowercase().filter { it.isDigit() || it.isLetter() }
        return normalized == normalized.reversed()
    }
}