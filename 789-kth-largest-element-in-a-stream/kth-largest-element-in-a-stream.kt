
class KthLargest(k: Int, nums: IntArray) {
    val minQueue = PriorityQueue<Int>(k)
    init {
        while (minQueue.size < k) {
            minQueue.add(Int.MIN_VALUE)
        }
        
        for (num in nums) {
            add(num)
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