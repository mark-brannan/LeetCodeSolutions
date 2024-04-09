class Solution {
    fun arrayStringsAreEqual(word1: Array<String>, word2: Array<String>): Boolean {
        val string1 = word1.joinToString("")
        val string2 = word2.joinToString("")
        return string1 == string2
    }
}