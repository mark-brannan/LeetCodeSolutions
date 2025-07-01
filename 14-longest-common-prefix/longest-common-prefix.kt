class Solution {
    fun longestCommonPrefix(strs: Array<String>): String {
        // LCP cannot longer than the shortest input string
        val maxPrefixLength = strs.map { it.length }.min()
        val prefixBuilder = StringBuilder(maxPrefixLength)

        // Consider the set of distinct characters for each string at position i:
        // If all the stings have the same char at that point, then it's part of the LCP.
        // If we have more than one character at that point, then it is not part of LCP
        // and we can halt.
        outerLoop@ for (i in 0..(maxPrefixLength-1)) {
            val nextChars = strs.map { it[i] }.distinct()
            when (nextChars.size) {
                1 -> prefixBuilder.append(nextChars.first())
                else -> break@outerLoop
            }
        }
        return prefixBuilder.toString()
    }
}