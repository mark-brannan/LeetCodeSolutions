class Solution {
    fun candy(ratings: IntArray): Int {
        val candies = IntArray(ratings.size) { 1 }

        for (i in 0..ratings.lastIndex) {
            // has a higher rating than child on left, but less candy
            if (i > 0 && ratings[i] > ratings[i-1] && candies[i] <= candies[i-1]) {
                candies[i] = candies[i-1] + 1
            }
        }

        for (i in ratings.lastIndex downTo 0) {
            // has a higher rating than child on right, but less candy
            if (i < ratings.lastIndex && ratings[i] > ratings[i+1] && candies[i] <= candies[i+1]) {
                candies[i] = candies[i+1] + 1
            }
        }

        return candies.sum()
    }
}