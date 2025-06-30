class Solution {
    fun findLHS(nums: IntArray): Int {
        var longest = 0
        val counts = nums.asList().groupingBy { it }.eachCount()

        for (k in counts.keys) {
            if (counts.containsKey(k + 1)) {
                val length = counts.getValue(k) + counts.getValue(k+1)
                longest = maxOf(longest, length)
            }
        }
        return longest
    }
}