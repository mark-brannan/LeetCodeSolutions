class Solution {
    fun hasTrailingZeros(nums: IntArray): Boolean {
        return nums.count { it.mod(2) == 0 } >= 2
    }
}