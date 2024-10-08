class Solution {
    fun canConstruct(ransomNote: String, magazine: String): Boolean {
        val magazineLetterCounts = magazine.groupingBy { it }.eachCount()
        val targetLetterCounts = ransomNote.groupingBy { it }.eachCount()
        return targetLetterCounts.all {
            (letter, targetCount) ->
                magazineLetterCounts.getOrDefault(letter, 0) >= targetCount
        }
    }
}