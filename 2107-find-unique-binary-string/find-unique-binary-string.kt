fun String.toIntFromBinary() = this.toInt(2)
fun Int.toBinaryString() = Integer.toBinaryString(Integer.valueOf(this))
fun Int.toBinaryString(n: Int) = this.toBinaryString().padStart(n, '0')

class Solution {
    fun findDifferentBinaryString(nums: Array<String>): String {
        val n = nums[0].length
        val max = "1".repeat(n).toIntFromBinary()
        val set = nums.map { it.toIntFromBinary() }.toHashSet()
        val differentInt = (0..max).filter { it !in set }.first()
        return differentInt.toBinaryString(n)
    }
}