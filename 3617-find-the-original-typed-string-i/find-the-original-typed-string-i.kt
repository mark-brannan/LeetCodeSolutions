class Solution {
    fun possibleStringCount(word: String): Int {
        var count = 1 // start with a count of 1 for the original, unmodified string
        for (i in word.indices) {
            // For each char that is a repeat of the previous char, increment the count;
            // Consider that for the string '...aaa...'
            // the intended words could be '...a...', '...aa...', '...aaa...'
            if (i > 0 && word[i] == word[i-1]) {
                ++count
            }
        }
        return count
    }
}