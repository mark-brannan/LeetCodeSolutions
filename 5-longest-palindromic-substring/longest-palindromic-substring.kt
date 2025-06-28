class Solution {
    fun longestPalindrome(s: String): String {
        var longest = s.substring(0, 1)
        for (i in s.indices) {
            for (j in i..s.length) {
                val substring = s.substring(i, j)
                //System.out.println("Checking $substring ($i, $j)...")
                if (substring.length > longest.length && substring.isPalindrome()) {
                    // System.out.println("new longest: $longest ($i, $j)")
                    longest = substring
                }
            }
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