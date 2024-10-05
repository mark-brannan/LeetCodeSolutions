class Solution {
    fun summaryRanges(nums: IntArray): List<String> {
        val output = mutableListOf<String>()
        if (nums.isEmpty()) return output
        
        val sorted = nums.sorted()
        var prevMin = nums[0]
        var prevMax = nums[0]
        for (x in sorted) {
            when (x) {
                prevMax -> {}
                prevMax + 1 -> prevMax = x
                else -> {
                    output.add(format(prevMin, prevMax))
                    prevMin = x
                    prevMax = x
                }
            }
        }
        output.add(format(prevMin, prevMax))
        return output
    }

    private fun format(min: Int, max: Int) = when {
        min == max -> "$min"
        else -> "$min->$max"
    }
}