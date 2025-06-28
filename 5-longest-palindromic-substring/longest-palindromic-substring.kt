class Solution {
    fun longestPalindrome(s: String): String {
        var longest = ""
        var length = 0

        fun check(leftStart: Int, rightStart: Int) {
            var (l, r) = leftStart to rightStart
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
            check(i, i) // odd lengths
            check(i, i + 1) // even lengths
        }
        return longest
    }
}