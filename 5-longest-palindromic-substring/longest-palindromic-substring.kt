class Solution {
    fun longestPalindrome(s: String): String {
        var longest = ""
        var length = 0

        fun check(left: Int, right: Int) {
            var (l, r) = left to right
            while (l >= 0 && r < s.length && s[l] == s[r]) {
                val substring = s.substring(l, r + 1)
                if (r - l + 1 > length) {
                    length = r - l + 1
                    longest = s.substring(l, r + 1)
                }
                --l
                ++r
            }
        }

        for (i in s.indices) {
            check(i, i)
            check(i, i + 1)
        }
        return longest
    }

    fun String.isPalindrome(): Boolean {
        for (i in 0..lastIndex) {
            val j = lastIndex - i
            when {
                this[i] == this[j] && i < j -> continue
                this[i] == this[j] && i >= j -> {
                    // System.out.println("palindrome: $this, $i, $j, ${this[i]} vs ${this[j]}")
                    return true
                }
                else -> break
            }
        }
        return false
    }
}