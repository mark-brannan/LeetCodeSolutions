class Solution {
    fun rotate(nums: IntArray, k: Int): Unit {
        if (k == 0 || nums.size == 1) {
            return
        }
        if (k >= nums.size) {
            rotate(nums, k - nums.size)
            return
        }
        val start = nums.size - k // "from" index, inclusive
        val end = nums.size // "to" index, exclusive
        val temp = nums.copyOfRange(start, end)
        val temp2 = nums.copyOfRange(0, start)
        temp.copyInto(nums)
        temp2.copyInto(nums, k)
    }
}