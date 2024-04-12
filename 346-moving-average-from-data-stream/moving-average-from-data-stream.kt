class MovingAverage(size: Int) {
    val windowSize = size
    val window = ArrayDeque<Int>(windowSize)

    fun next(`val`: Int): Double {
        window.add(`val`)
        if (window.size > windowSize) {
            window.removeFirst()
        }

        val sum = 1.0 * window.sum()
        val count = window.count { it != null }
        return sum / count
    }

}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * var obj = MovingAverage(size)
 * var param_1 = obj.next(`val`)
 */