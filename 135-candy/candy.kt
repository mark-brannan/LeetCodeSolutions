class Solution {
    fun candy(ratings: IntArray): Int {
        val candies = IntArray(ratings.size) { 1 }

        fun childNeedsMoreAtIndex(i: Int): Boolean {
            // has another child on left, and has a higher rating than them, but less candy
            if (i > 0 && ratings[i] > ratings[i-1] && candies[i] <= candies[i-1]) {
                return true
            }

            // has another child on right, and has a higher rating than them, but less candy
            if (i < ratings.lastIndex && ratings[i] > ratings[i+1] && candies[i] <= candies[i+1]) {
                return true
            }
            return false
        }

        var i = 0
        var stillGivingCandy = true
        while (stillGivingCandy) {
            stillGivingCandy = false
            for (i in 0..ratings.lastIndex) {
                when {
                    childNeedsMoreAtIndex(i) -> {
                        ++candies[i]
                        stillGivingCandy = true
                    }
                }
            }
        }

        return candies.sum()
    }
}