class Solution {
    fun shortestPalindrome(s: String): String {
        // naively, the worst case is the length + (length - 1)
        // and size 1 strings are trivially already a palindrome
        val worstCase = maxOf(s.length, s.length + (s.length - 1))
        val builder = StringBuilder(worstCase)

        // start with the input string itself
        builder.append(s)
        var i = 0
        var j = s.lastIndex

        // if neccessary, prepend characters from the end,
        // one at a time, at the mirrored index for each char
        while (builder.toString().isPalindrome() == false) {
            builder.insert(i, s[j])
            ++i
            --j
        }

        return builder.toString()
    }
}

fun String.isPalindrome(): Boolean {
    if (length <= 1) return true

    for (i in 0..lastIndex) {
        val j = lastIndex - i
        when {
            this[i] == this[j] && i < j -> continue
            this[i] == this[j] && i >= j -> return true
            else -> break
        }
    }
    return false
}