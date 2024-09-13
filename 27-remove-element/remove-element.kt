class Solution {
    fun removeElement(nums: IntArray, `val`: Int): Int {
        var (i, j) = 0 to nums.lastIndex
        while (i <= j) {
            when {
                nums[j] == `val` -> --j
                nums[i] == `val` -> nums[i++] = nums[j--]
                else -> ++i
            }
        }
        return i
    }
}