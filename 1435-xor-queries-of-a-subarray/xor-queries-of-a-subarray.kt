class Solution {
    fun xorQueries(arr: IntArray, queries: Array<IntArray>): IntArray {
        val xorPrefixes  = IntArray(arr.size + 1) { 0 }
        for ((i, x) in arr.withIndex()) {
            xorPrefixes[i + 1] = x xor xorPrefixes[i]
        }

        return queries.map { it[0] to it[1] }
            .map { (left, right) -> xorPrefixes[left] xor xorPrefixes[right + 1] }
            .toIntArray()
    }
}