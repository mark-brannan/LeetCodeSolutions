class Solution {
    fun minSwaps(s: String): Int {
        val charArray = s.toCharArray()
        var openingCount = 0
        var closingCount = 0
        var swaps = 0
        var j = charArray.lastIndex

        fun findLastIndexOfOpening(): Int {
            while (charArray[j] != '[') {
                --j
            }
            return j
        }

        for (i in 0..charArray.lastIndex) {
            when (charArray[i]) {
                '[' -> ++openingCount
                ']' -> ++closingCount
            }

            if (closingCount > openingCount) {
                j = findLastIndexOfOpening()
                charArray[i] = '['
                charArray[j] = ']'
                --closingCount
                ++openingCount
                ++swaps
            }
        }
        return swaps
    }
}