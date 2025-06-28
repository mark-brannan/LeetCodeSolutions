class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        nums.sort()
        System.out.println("${nums.toList()}")
        val results = mutableSetOf<List<Int>>()

        for (i in 0..(nums.lastIndex - 2)) {
            when {
                nums[i] > 0 -> break // after this point no three would sum to zero
                i > 0 && nums[i] == nums[i - 1] -> continue // don't check duplicates
            }

            var (j, k) = i + 1 to nums.lastIndex
            while (j < k) {
                val sum = nums[i] + nums[j] + nums[k]
                //System.out.println("$i, $j, $j: ${nums[i]}+${nums[j]}+${nums[k]} = $sum")
                when {
                    sum < 0 -> ++j
                    sum > 0 -> --k
                    else -> {
                        val triple = listOf(nums[i], nums[j], nums[k])
                        results.add(triple)
                        ++j
                        --k
                    }
                }
            }
        }
        return results.toList()
    }
}