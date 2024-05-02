class Solution {
    fun countDistinctIntegers(nums: IntArray): Int {
        val numSet: Set<Int> = nums.toSet()
        val reversedSet: Set<Int> = numSet.map { it.reverseDigits() }.toSet()
        return (numSet + reversedSet).size
    }

    private fun Int.reverseDigits() = this.toString().reversed().toInt()
}