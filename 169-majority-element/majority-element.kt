class Solution {
    fun majorityElement(nums: IntArray): Int {
        val n = nums.lastIndex
        return nums.asList()
            .groupingBy { it }.eachCount()
            .filterValues { it > (n/2) }
            .keys
            .first()
    }
}