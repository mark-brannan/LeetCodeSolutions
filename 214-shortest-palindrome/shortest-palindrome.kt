class Solution {
    fun shortestPalindrome(s: String): String {

        // naively, the worst case is the length + (length - 1)
        // size 1 strings are trivially already a palindrome
        val worstCasePrefixLength = maxOf(1, s.length - 1)
        val prefix = CharArray(worstCasePrefixLength)
        var i = 0
        var j = s.lastIndex

        // start with the input string itself, consider prepending
        // an empty prefix string.  Then, adding characters from
        // the end of the string, one at a time, consider
        // prepending each new set of prefix characters

        while (isPalindrome(i - 1, prefix, s) == false) {
            prefix[i] = s[j]
            ++i
            --j
        }

        return prefix.concatToString(0, i) + s
    }
}

fun isPalindrome(i: Int, prefix: CharArray, s: String): Boolean {
    var (left, right) = 0 to s.lastIndex
    while (left < right + i + 1) {
        val leftChar = when {
            left > i -> s[left - (i + 1)]
            else -> prefix[left]
        }
        if (leftChar != s[right]) return false
        ++left 
        --right
    }
    return true
}
