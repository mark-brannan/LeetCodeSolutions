class SparseVector(val nums: IntArray) {
    fun dotProduct(vec: SparseVector): Int {
        var sumOfNonZeroProducts = 0
        for (i in nums.indices) {
            when {
                nums[i] == 0 -> {}
                vec.nums[i] == 0 -> {}
                else -> sumOfNonZeroProducts += nums[i] * vec.nums[i]
            }
        }
        return sumOfNonZeroProducts
    }
}

/**
 * Your SparseVector object will be instantiated and called as such:
 * var v1 = SparseVector(nums1)
 * var v2 = SparseVector(nums2)
 * val ans = v1.dotProduct(v2)
 */