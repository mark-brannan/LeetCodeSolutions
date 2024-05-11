class Solution {
    fun canPlaceFlowers(flowerbed: IntArray, n: Int): Boolean {
        var count = 0
        for (i in 0..flowerbed.lastIndex) {
            val left = if (i > 0 ) flowerbed[i - 1] else 0
            val right = if (i < flowerbed.lastIndex) flowerbed[i + 1] else 0
            when {
                left == 0 && right ==0 && flowerbed[i] == 0 -> {
                    flowerbed[i] = 1
                    ++count
                }
            }
            if (count >= n) return true
        }
        return false
    }
}