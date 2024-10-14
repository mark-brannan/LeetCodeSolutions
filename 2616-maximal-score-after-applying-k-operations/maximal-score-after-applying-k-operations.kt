class Solution {
    val greatestFirst: Comparator<Int> = java.util.Comparator.naturalOrder<Int>().reversed()

    fun maxKelements(nums: IntArray, k: Int): Long {
        var score = 0L
        val heap = PriorityQueue<Int>(nums.size, greatestFirst)
        nums.forEach { heap.offer(it) }

        repeat(k) {
            val num = heap.poll()
            score += num
            heap.offer(ceil(num / 3.toDouble()).toInt())
        }

        return score
    }
}