class Solution {
    fun countConsistentStrings(allowed: String, words: Array<String>): Int {
        val allowedSet = allowed.map { it }.toSet()
        fun String.isAllowed() = this.all { allowedSet.contains(it) }

        return words.count { it.isAllowed() }
    }
}