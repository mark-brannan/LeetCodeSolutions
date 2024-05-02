class Solution {
    fun findMaxK(nums: IntArray): Int {
        val map = nums.associateBy { it }
        return map.keys.sorted().reversed().find { (-it) in map.keys } ?: -1
    }
}