
class Solution {
    fun maxSubsequence(nums: IntArray, k: Int): IntArray {
        
        // Use a priority queue of pairs of index+value, with
        // largest values at the top (descending)
        val comparator =  compareByDescending<Pair<Int, Int>> { it.second }
        val queue = PriorityQueue<Pair<Int, Int>> (comparator)
        for ((i, num) in nums.withIndex()) {
            queue.add(Pair(i, num))
        }

        // Use the PQ to get the k largest values and indexes
        val kLargest = mutableListOf<Pair<Int, Int>>()
        repeat(k) {
            kLargest.add(queue.poll())
        }

        // sort by index to preserve original order,
        // and then map the pairs to just the original value
        return kLargest.sortedBy { it.first }
            .map { it.second }
            .toIntArray()
    }
}