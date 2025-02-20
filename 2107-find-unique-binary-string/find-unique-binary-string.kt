
class Solution {
    fun findDifferentBinaryString(nums: Array<String>): String {
        val n = nums[0].length
        val max = "1".repeat(n).toInt(2)
        val set = nums.map { it.toInt(2) }.sorted().toSet()
        val differentInt = (0..max).toSet().subtract(set).first()
        val javaInteger = Integer.valueOf(differentInt)
        return Integer.toBinaryString(javaInteger).padStart(n, '0')
    }
}