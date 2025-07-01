class KthLargest(k: Int, nums: IntArray) {
    val minQueue = PriorityQueue<Int>(k)
    init {
        for (num in nums) {
            when {
                minQueue.size >= k -> this.add(num)
                else -> minQueue.add(num)
            }
        }
        if (minQueue.size < k) {
            minQueue.add(Int.MIN_VALUE)
        }
    }

    fun add(`val`: Int): Int {
        if (`val` > minQueue.peek() ?: 0) {
            minQueue.poll()
            minQueue.add(`val`)
        }
        return minQueue.peek()
    }

}

/**
 * Your KthLargest object will be instantiated and called as such:
 * var obj = KthLargest(k, nums)
 * var param_1 = obj.add(`val`)
 */