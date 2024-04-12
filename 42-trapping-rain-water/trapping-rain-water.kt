class Solution {
    fun trap(height: IntArray): Int {
        var left = 0
        var right = height.lastIndex
        var maxLeft = 0
        var maxRight = 0
        var total = 0

        while (left < right) {
            maxLeft = maxOf(maxLeft, height[left])
            maxRight = maxOf(maxRight, height[right])
            val level = minOf(maxLeft, maxRight)

            if (height[left] < height[right]) {
                total += abs(level - height[left])
                ++left
            } else {
                total += abs(level - height[right])
                --right
            }
        }
        return total
    }
}