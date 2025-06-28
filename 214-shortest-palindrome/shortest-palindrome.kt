class Solution {
    // KMP algorithm
    fun shortestPalindrome(s: String): String {
        val combinedString = s + "#" + s.reversed()
        val prefixTable = buildPrefixTable(combinedString)

        val longestPrefixLength = prefixTable[combinedString.length - 1]
        val suffix = s.substring(longestPrefixLength)

        return suffix.reversed() + s
    }
}

fun buildPrefixTable(s: String): IntArray {
    val prefixTable = IntArray(s.length) { 0 }
    var length = 0
    
    for (i in 1..s.lastIndex) {
        length = prefixTable[i-1]
        while (length > 0 && s[i] != s[length]) {
            length = prefixTable[length - 1]
        }

        if (s[i] == s[length]) {
            ++length
        }

        prefixTable[i] = length
    }

    return prefixTable
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
