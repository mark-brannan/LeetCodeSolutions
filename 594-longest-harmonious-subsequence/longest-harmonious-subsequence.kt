class Solution {
    fun findLHS(nums: IntArray): Int {
        var longest = 0
        val counts = nums.asList().groupingBy { it }.eachCount()
        val set = nums.toSortedSet()

        for (k in set) {
            if (k + 1 in set) {
                val length = counts.getValue(k) + counts.getValue(k+1)
                longest = maxOf(longest, length)
            }
        }
        return longest
    }
}