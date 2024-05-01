class Solution {
    fun reversePrefix(word: String, ch: Char): String {
        val i = word.indexOf(ch)
        val remainder = if (i < word.lastIndex) word.substring(i+1) else ""
        return word.substring(0..i).reversed() + remainder
    }
}