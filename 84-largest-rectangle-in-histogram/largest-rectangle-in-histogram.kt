class Solution {
    fun largestRectangleArea(heights: IntArray): Int {
        var maxArea = 0
        val stack = ArrayDeque<Pair<Int, Int>>()
        for ((i, h) in heights.withIndex()) {
            // if height decreases, look back to start of that height
            var start = i
            while (stack.isNotEmpty() && stack.last().second > h) {
                val (index, height) = stack.removeLast()
                maxArea = maxOf(maxArea, height * (i - index))
                start = index
            }
            stack.add(start to h)
        }

        for ((i, h) in stack) {
            val spanWidth:Int = heights.size - i
            maxArea = maxOf(maxArea, h * spanWidth)
        }
        return maxArea
    }
}