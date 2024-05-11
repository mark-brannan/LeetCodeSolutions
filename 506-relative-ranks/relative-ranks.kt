class Solution {
    fun findRelativeRanks(score: IntArray): Array<String> {
        val scoreToRank = score.sorted()
            .reversed()
            .withIndex()
            .associate { it.value to (it.index + 1) }
            
        return score.map { scoreToRank[it]!!.toPlaceString() }.toTypedArray()
    }

    internal fun Int.toPlaceString() = when (this) {
        1 -> "Gold Medal"
        2 -> "Silver Medal"
        3 -> "Bronze Medal"
        else -> this.toString()
    }
}