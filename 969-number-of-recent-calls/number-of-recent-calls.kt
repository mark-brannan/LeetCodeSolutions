class RecentCounter() {
    val queue = ArrayDeque<Int>()

    fun ping(t: Int): Int {
        queue.add(t)

        val window = t - 3000
        while (queue.first() < window) {
            queue.removeFirst()
        }
        return queue.size
    }

}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * var obj = RecentCounter()
 * var param_1 = obj.ping(t)
 */