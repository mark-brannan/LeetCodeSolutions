class Solution {
    fun minBitFlips(start: Int, goal: Int): Int {
        val diff = start xor goal
        return diff.toString(2).map { if (it == '1') 1 else 0 }.sum()
    }
}