class Solution {
    fun longestCommonPrefix(strs: Array<String>): String {
        val maxPrefixLength = strs.map { it.length }.min()
        val prefixBuilder = StringBuilder(maxPrefixLength)

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