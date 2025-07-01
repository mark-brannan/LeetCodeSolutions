class Solution {
    fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
        val counts1 = nums1.toList().groupingBy { it }.eachCount()
        val counts2 = nums2.toList().groupingBy { it }.eachCount()

        val commonKeys = counts1.keys.intersect(counts2.keys)

        val result = mutableListOf<Int>()
        for (key in commonKeys) {
            val count = minOf(counts1.getValue(key), counts2.getValue(key))
            repeat(count) {
                result.add(key)
            }
        }
        return result.toIntArray()
    }
}